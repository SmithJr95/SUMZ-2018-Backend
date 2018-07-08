package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.config.EmailConfig;
import edu.dhbw.ka.mwi.businesshorizon2.config.SecurityConfig;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IAppRoleRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IAppUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserActivationTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserPasswordResetTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppRoleDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserActivationTokenDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.AppUserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPasswordResetTokenDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.UserMapper;

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
	public AppUserDao addUser(AppUserDto userDto, String host) throws Exception {
		
		AppUserDao user = UserMapper.mapToDao(userDto); 
		
		AppUserDao userFromDB = userRepository.findByEmail(user.getEmail());
		
		if (userFromDB != null) {
			String s = user.getEmail();
			throw new Exception(String.format("Es existiert schon ein Benutzerkonto für die Email-Adresse %s. Bitte wählen Sie eine andere Email-Adresse.", s));
		}
		
		user.setPassword(encodePassword(user.getAppUserPassword()));
		
		ArrayList<AppRoleDao> roles = new ArrayList<AppRoleDao>();
	
		roles.add(roleRepository.findById((long) 1).get());
		user.setAppRoles(roles);
		user.setIsActive(false);
		AppUserDao userResult = userRepository.save(user);
		
		UserActivationTokenDao userToken = userActivationService.createUserActivationToken(userResult);
		UserActivationTokenDto userTokenDto = UserMapper.mapToDto(userToken);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String link = objectMapper.writeValueAsString(userTokenDto); 
		
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
		UserActivationTokenDto token = objectMapper.readValue(tokenStr, UserActivationTokenDto.class);
		
		UserActivationTokenDao tokenDao = UserMapper.mapToDao(token);
		tokenDao.setAppUser(userRepository.findById(token.getAppUserId()).get());
		
		Optional<UserActivationTokenDao> tokenFromDB = userActivationTokenRepository.findById(tokenDao.getUserActivationTokenId());
		AppUserDao user = userRepository.findById(token.getAppUserId()).get();
		
		UserActivationTokenDao tokenFromDBObject = null;
		
		if (tokenFromDB.isPresent()) {
			tokenFromDBObject = tokenFromDB.get();
		}else {
			throw new Exception("Der verwendete Token existiert nicht.");
		}
		
		Boolean tokenExists			= tokenFromDB.isPresent();
		Boolean tokenIsValid 		= tokenDao.equals(tokenFromDBObject);
		Boolean tokenIsUnexpired 	= tokenDao.getExpirationDate().isAfter(LocalDateTime.now());
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
		AppUserDao user = userRepository.findByEmail(email);
		
		if (user == null){
			throw new UsernameNotFoundException("Das Benutzerkonto " + email + " existiert nicht.");
		}
		
		if(!user.getIsActive()) {
			throw new Exception("Das Benutzerkonto, bei dem das Passwort zurückgesetzt werden soll, ist inaktiv.");
		}
		
		UserPasswordResetTokenDao userToken = userPasswordResetService.createUserPasswordResetToken(user);
		UserPasswordResetTokenDto userTokenDto = UserMapper.mapToDto(userToken);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String token = objectMapper.writeValueAsString(userTokenDto); 
		
		token 		= Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
		String link = host + "/users/forgot/" + token;
		
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
		UserPasswordResetTokenDto tokenDto = objectMapper.readValue(tokenStr, UserPasswordResetTokenDto.class);
		
		System.out.println(tokenDto);
		
		UserPasswordResetTokenDao token = UserMapper.mapToDao(tokenDto);
		token.setAppUser(userRepository.findById(tokenDto.getAppUserId()).get());
		
		UserPasswordResetTokenDao tokenFromDB = userPasswordResetTokenRepository.findById(token.getUserPasswordResetTokenId()).get();
		AppUserDao user = userRepository.findById(token.getAppUser().getAppUserId()).get();
		
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
	public void resetUserPassword(@Valid AppUserDto userDto, String tokenStr) throws Exception {
		
		UserPasswordResetTokenDao token = checkPasswordResetToken(tokenStr);
		
		Long userId = token.getAppUser().getAppUserId();
		
		Optional<AppUserDao> user = userRepository.findById(userId);	
		
		if (user != null) {
			AppUserDao userFromDB = user.get();
			userFromDB.setPassword(encodePassword(userDto.getPassword()));
			userRepository.save(userFromDB);
			userPasswordResetTokenRepository.delete(token);
		}else {
			throw new Exception("Der im Token angegebene User existiert nicht."); 
		}
	}
	
	@Override
	public String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		return (passwordEncoder.encode(password));
	}
	
	@Override 
	public void updateUserPassword(UserPutRequestDto user, Long userID) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		
		AppUserDao oldUser = UserMapper.mapPutRequestOldToDao(user);
		AppUserDao newUser = UserMapper.mapPutRequestNewToDao(user);
		
		oldUser.setPassword(oldUser.getAppUserPassword());
		newUser.setPassword(encodePassword(newUser.getAppUserPassword()));
		
		Optional<AppUserDao> userFromDb = userRepository.findById(userID);
		
		if (userFromDb.isPresent()){
			
			AppUserDao userFromDbObject = userFromDb.get();
			Boolean oldPasswordIsCorrect = passwordEncoder.matches(oldUser.getAppUserPassword(), userFromDbObject.getAppUserPassword());
			
			if (oldPasswordIsCorrect){
				
				userFromDbObject.setPassword(newUser.getAppUserPassword());
				userRepository.save(userFromDbObject);
				
			}else {
				throw new Exception("Sie haben ein falsches altes Passwort angegeben.");
			}
		}else {
			throw new Exception("Es existiert kein Benutzerkonto mit der ID: " + userID + ".");
		}
	}
	
	@Override
	public void deleteUser(@Valid AppUserDto userDto, Long id) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		
		AppUserDao user = UserMapper.mapToDao(userDto);
		
		Optional<AppUserDao> userFromDb = userRepository.findById(id);
		
		if (userFromDb.isPresent()) {
			
			AppUserDao userFromDbObject = userFromDb.get();
			Boolean passwordIsCorrect = passwordEncoder.matches(user.getAppUserPassword(), userFromDbObject.getAppUserPassword());
			if (passwordIsCorrect) {
				userRepository.delete(userFromDbObject);
			}else {
				throw new Exception("Sie haben ein falsches Passwort angegeben.");
			}
		}else {
			throw new Exception("Es existiert kein Benutzerkonto mit der ID: " + id + ".");
		}
	}
	
	@Override 
	public Long getUserId(String username) {
		AppUserDao user = userRepository.findByEmail(username);
		
		return user.getAppUserId();
	}

}
