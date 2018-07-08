package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserActivationService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserActivationTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;

@Service
public class UserActivationService implements IUserActivationService {
	
	@Autowired 
	private IUserActivationTokenRepository userActivationTokenRepository; 

	public UserActivationTokenDao createUserActivationToken(AppUserDao appUser) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		Long userId = appUser.getAppUserId();
		
		LocalDateTime expirationDate = LocalDateTime.now(); 
		expirationDate = expirationDate.withNano(0); 
		expirationDate = expirationDate.withSecond(0);
		
		expirationDate = expirationDate.plusDays(1); 
				
		String tokenKey = "SUMZ1718";
		tokenKey += (appUser.getEmail().toString());
		tokenKey += (appUser.getAppUserId().toString()); 
		tokenKey += (expirationDate.toString());	
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		md5.update(tokenKey.getBytes());
		byte[] digest = md5.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}	
		
		tokenKey = sb.toString();
		
		UserActivationTokenDao userActivationToken = new UserActivationTokenDao(null, appUser, expirationDate, tokenKey); 
		userActivationToken = userActivationTokenRepository.save(userActivationToken);
		
		return userActivationToken; 
	}
	
}
