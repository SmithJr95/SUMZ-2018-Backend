package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
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
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.RoleDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

@Service
public class UserService implements IUserService {
	
    @Autowired 
    SecurityConfig securityConfig;
    
    @Autowired 
    UserActivationService userActivationService;
    
    @Autowired 
    EmailService emailService;
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IRoleRepository roleRepository; 
    
    @Autowired 
    private IUserActivationTokenRepository userActivationTokenRepository;
    
    @Override
    public List<UserDao> findAllUsers() {
        return (List<UserDao>)userRepository.findAll();
    }
   
	@Override
	public UserDao findByEmail(String s) {
		return userRepository.findByEmail(s);
	}
	
	@Override
	public UserDao addUser(UserDao user) throws MessagingException, JsonProcessingException, NoSuchAlgorithmException, UnsupportedEncodingException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(securityConfig.getEncodingStrength());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
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
		link = "http://localhost:8080/user/activate/" + link;
		
		emailService.sendEmail(
				"matthias.kugel@gmx.de", 
				user.getEmail(), 
				"TEST", 
				"<a href=\"" + link + "\">test</a>");
				
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
		
		System.out.println(tokenIsValid.toString() + tokenIsUnexpired + userIsInactive);
		
		if (tokenIsValid && tokenIsUnexpired && userIsInactive) {
			user.setIsActive(true);
			userRepository.save(user);
		}
		
		
	}
}
