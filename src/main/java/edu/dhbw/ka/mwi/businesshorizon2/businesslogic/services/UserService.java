package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.config.EmailConfig;
import edu.dhbw.ka.mwi.businesshorizon2.config.SecurityConfig;


@Service
public class UserService implements IUserService {
	
    @Autowired 
    private SecurityConfig securityConfig;
    
    @Autowired
    EmailConfig emailConfig;
    
    @Autowired 
    private UserActivationService userActivationService;
    
    @Autowired 
    private UserPasswordResetService userPasswordResetService; 
    
    @Autowired 
    private EmailService emailService;

    
    @Autowired
    private IAppUserRepository userRepository;
    
    @Autowired
    private IAppRoleRepository roleRepository; 
    
    @Autowired 
    private IUserActivationTokenRepository userActivationTokenRepository;
    
    @Autowired
    private IUserPasswordResetTokenRepository userPasswordResetTokenRepository;
    
    @Override
    public List<AppUserDao> findAllUsers() {
        return (List<AppUserDao>)userRepository.findAll();
    }
   
	@Override
	public AppUserDao findByEmail(String s) {
		return userRepository.findByEmail(s);
	}
	
	@Override
	public AppUserDao addUser(AppUserDao user, String host) throws Exception {
		
		AppUserDao userFromDB = userRepository.findByEmail(user.getEmail());
		
		if (userFromDB != null) {
			String s = user.getEmail();
			throw new Exception(String.format("Es existiert schon ein Benutzerkonto für die Email-Adresse %s. Bitte wählen Sie eine andere Email-Adresse.", s));
		}
		
		user.setPassword(encodePassword(user.getPassword()));
		
		ArrayList<AppRoleDao> roles = new ArrayList<AppRoleDao>();
	
		roles.add(roleRepository.findById((long) 1).get());
		user.setAppRoles(roles);
		user.setIsActive(false);
		AppUserDao userResult = userRepository.save(user);
		
		UserActivationTokenDao userToken = userActivationService.createUserActivationToken(userResult);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String link = objectMapper.writeValueAsString(userToken); 
		
		link = Base64.getEncoder().encodeToString(link.getBytes(StandardCharsets.UTF_8));
		link = host + "/activate/" + link;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", user.getEmail());
		map.put("link", link);
		map.put("imageResourceName", "logo.png");
		
		emailService.sendEmail(
				emailConfig.getUsername(), 
				user.getEmail(), 
				"Ihre Registrierung bei business horizon", 
				"activation",
				map);
				
		return userResult;
	}
	
	@Override 
	public void activateUser(String tokenStr) throws Exception {
		byte[] bytes = Base64.getDecoder().decode(tokenStr);
		tokenStr = new String(bytes);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		UserActivationTokenDao token = objectMapper.readValue(tokenStr, UserActivationTokenDao.class);
		
		UserActivationTokenDao tokenFromDB = userActivationTokenRepository.findById(token.getUserActivationTokenId()).get();
		AppUserDao user = userRepository.findById(token.getAppUser().getAppUserId()).get();
		
		UserActivationTokenDao tokenFromDBObject = null;
		
		if (tokenFromDB.isPresent()) {
			tokenFromDBObject = tokenFromDB.get();
		}else {
			throw new Exception("Der verwendete Token existiert nicht.");
		}
		
		Boolean tokenExists			= tokenFromDB.isPresent();
		Boolean tokenIsValid 		= token.equals(tokenFromDBObject);
		Boolean tokenIsUnexpired 	= token.getExpirationDate().isAfter(LocalDateTime.now());
		Boolean userIsInactive 		= !user.getIsActive();

		if (tokenExists && tokenIsValid && tokenIsUnexpired && userIsInactive ) {
			user.setIsActive(true);
			userRepository.save(user);
			userActivationTokenRepository.delete(tokenFromDBObject);
		}else {
			throw new Exception("Der verwendete Token ist ungültig.");
		}
		
	}
	
	@Override 
	public String requestUserPasswordReset(String email, String host) throws Exception{
		UserDao user = userRepository.findByEmail(email);
		
		if (user == null){
			throw new UsernameNotFoundException("Das Benutzerkonto " + email + " existiert nicht.");
		}
		
		if(!user.getIsActive()) {
			throw new Exception("Das Benutzerkonto, bei dem das Passwort zurückgesetzt werden soll, ist inaktiv.");
		}
		
		UserPasswordResetTokenDao userToken = userPasswordResetService.createUserPasswordResetToken(user);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String token = objectMapper.writeValueAsString(userToken); 
		
		token 		= Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
		String link = host + "/users/reset/" + token;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", user.getEmail());
		map.put("link", link);
		map.put("imageResourceName", "logo.png");
		
		emailService.sendEmail(
				emailConfig.getUsername(), 
				user.getEmail(), 
				"Zurücksetzen Ihres Passworts bei business horizon", 
				"password-reset",
				map);
		
		return token;
	}
	
	@Override 
	public UserPasswordResetTokenDao checkPasswordResetToken(String tokenStr) throws Exception {
		byte[] bytes = Base64.getDecoder().decode(tokenStr);
		tokenStr = new String(bytes);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		UserPasswordResetTokenDao token = objectMapper.readValue(tokenStr, UserPasswordResetTokenDao.class);
		
		UserPasswordResetTokenDao tokenFromDB = userPasswordResetTokenRepository.findById(token.getId()).get();
		UserDao user = userRepository.findById(token.getUserId()).get();
		
		Boolean tokenIsValid 		= token.equals(tokenFromDB);
		Boolean tokenIsUnexpired 	= token.getExpirationDate().isAfter(LocalDateTime.now());
		Boolean userIsActive 		= user.getIsActive();
		
		if (!tokenIsValid) {
			throw new Exception("Der gesendete Token zum Zurücksetzen des Passworts ist ungültig.");
		}
		
		if(!tokenIsUnexpired) {
			throw new Exception("Der gesendete Token zum Zurücksetzen des Passworts ist abgelaufen.");		
		}
		
		if(!userIsActive) {
			throw new Exception("Das Benutzerkonto, bei dem das Passwort zurückgesetzt werden soll, ist inaktiv.");
		}
		
		return tokenFromDB;
	}
	
	@Override 
	public void resetUserPassword(UserDao user, String tokenStr) throws Exception {
		
		UserPasswordResetTokenDao token = checkPasswordResetToken(tokenStr);
		
		UserDao userFromDB = userRepository.findById(token.getUserId()).get();	
		userFromDB.setPassword(encodePassword(user.getPassword()));
		userRepository.save(userFromDB);
		userPasswordResetTokenRepository.delete(token);
		
	}
	
	@Override
	public String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		return (passwordEncoder.encode(password));
	}
	
	@Override 
	public void updateUserPassword(UserDao oldUser, UserDao newUser, Long userID) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		
		oldUser.setPassword(oldUser.getPassword());
		newUser.setPassword(encodePassword(newUser.getPassword()));
		
		Optional<UserDao> userFromDb = userRepository.findById(userID);
		
		if (userFromDb.isPresent()){
			
			UserDao userFromDbObject = userFromDb.get();
			Boolean oldPasswordIsCorrect = passwordEncoder.matches(oldUser.getPassword(), userFromDbObject.getPassword());
			
			if (oldPasswordIsCorrect){
				
				userFromDbObject.setPassword(newUser.getPassword());
				userRepository.save(userFromDbObject);
				
			}else {
				throw new Exception("Sie haben ein falsches altes Passwort angegeben.");
			}
		}else {
			throw new Exception("Es existiert kein Benutzerkonto mit der ID: " + userID + ".");
		}
	}
	
	@Override
	public void deleteUser(UserDao user, Long id) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		
		Optional<UserDao> userFromDb = userRepository.findById(id);
		
		if (userFromDb.isPresent()) {
			
			UserDao userFromDbObject = userFromDb.get();
			Boolean passwordIsCorrect = passwordEncoder.matches(user.getPassword(), userFromDbObject.getPassword());
			if (passwordIsCorrect) {
				userRepository.delete(userFromDbObject);
			}else {
				throw new Exception("Sie haben ein falsches Passwort angegeben.");
			}
		}else {
			throw new Exception("Es existiert kein Benutzerkonto mit der ID: " + id + ".");
		}
	}
}
