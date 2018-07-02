package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import edu.dhbw.ka.mwi.businesshorizon2.config.SecurityConfig;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IRoleRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserActivationTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserPasswordResetTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.RoleDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;

@Service
public class UserService implements IUserService {
	
    @Autowired 
    SecurityConfig securityConfig;
    
    @Autowired 
    UserActivationService userActivationService;
    
    @Autowired 
    UserPasswordResetService userPasswordResetService; 
    
    @Autowired 
    EmailService emailService;
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IRoleRepository roleRepository; 
    
    @Autowired 
    private IUserActivationTokenRepository userActivationTokenRepository;
    
    @Autowired
    private IUserPasswordResetTokenRepository userPasswordResetTokenRepository;
    
    @Override
    public List<UserDao> findAllUsers() {
        return (List<UserDao>)userRepository.findAll();
    }
   
	@Override
	public UserDao findByEmail(String s) {
		return userRepository.findByEmail(s);
	}
	
	@Override
	public UserDao addUser(UserDao user) throws Exception {
		
		UserDao userFromDB = userRepository.findByEmail(user.getEmail());
		
		if (userFromDB != null) {
			String s = user.getEmail();
			throw new Exception(String.format("Es existiert schon ein Benutzerkonto für die Email-Adresse %s. Bitte wählen Sie eine andere Email-Adresse.", s));
		}
		
		user.setPassword(encodePassword(user.getPassword()));
		
		ArrayList<RoleDao> roles = new ArrayList<RoleDao>();
		roles.add(roleRepository.findById((long) 1).get());
		user.setRoles(roles);
		user.setIsActive(false);
		UserDao userResult = userRepository.save(user);
		
		UserActivationTokenDao userToken = userActivationService.createUserActivationToken(userResult);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String link = objectMapper.writeValueAsString(userToken); 
		
		link = Base64.getEncoder().encodeToString(link.getBytes());
		link = "http://localhost:8080/users/activate/" + link;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", user.getEmail());
		map.put("link", link);
		map.put("imageResourceName", "logo.png");
		
		emailService.sendEmail(
				"sumz1718@gmx.de", 
				user.getEmail(), 
				"Ihre Registrierung bei business horizon", 
				"activation",
				map);
				
		return userResult;
	}
	
	@Override 
	public void activateUser(String tokenStr) throws JsonParseException, JsonMappingException, IOException {
		byte[] bytes = Base64.getDecoder().decode(tokenStr);
		tokenStr = new String(bytes);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		UserActivationTokenDao token = objectMapper.readValue(tokenStr, UserActivationTokenDao.class);
		
		UserActivationTokenDao tokenFromDB = userActivationTokenRepository.findById(token.getId()).get();
		UserDao user = userRepository.findById(token.getUserId()).get();
		
		Boolean tokenIsValid 		= token.equals(tokenFromDB);
		Boolean tokenIsUnexpired 	= token.getExpirationDate().isAfter(LocalDateTime.now());
		Boolean userIsInactive 		= !user.getIsActive();

		if (tokenIsValid && tokenIsUnexpired && userIsInactive) {
			user.setIsActive(true);
			userRepository.save(user);
		}		
	}
	
	@Override 
	public String requestUserPasswordReset(String email) throws Exception{
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
		
		token 		= Base64.getEncoder().encodeToString(token.getBytes());
		String link = "http://localhost:8080/users/forgot/" + token;
		

		
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
		
	}
	
	public String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		return (passwordEncoder.encode(password));
	}
}
