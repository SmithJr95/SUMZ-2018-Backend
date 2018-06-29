package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserActivationService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserActivationTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

@Service
public class UserActivationService implements IUserActivationService {
	
	@Autowired 
	IUserActivationTokenRepository userActivationTokenRepository; 
	
	public UserActivationTokenDao createUserActivationToken(UserDao user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		Long userId = user.getId();
		
		LocalDateTime expirationDate = LocalDateTime.now(); 
		expirationDate = expirationDate.plusDays(1); 
				
		String key = "SUMZ1718";
		key += (user.getEmail().toString());
		key += (user.getId().toString()); 
		key += (expirationDate.toString());	
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		md5.update(key.getBytes());
		byte[] digest = md5.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}	
		
		key = sb.toString();
			
		UserActivationTokenDao userActivationToken = new UserActivationTokenDao(userId, expirationDate, key); 
		
		userActivationToken = userActivationTokenRepository.save(userActivationToken);
		
		return userActivationToken; 
	}
	
}
