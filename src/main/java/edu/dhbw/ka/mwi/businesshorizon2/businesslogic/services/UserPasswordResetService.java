package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserPasswordResetService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserPasswordResetTokenRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;

@Service
public class UserPasswordResetService implements IUserPasswordResetService {
	
	@Autowired
	IUserPasswordResetTokenRepository userPasswordResetTokenRepository;
	
	public UserPasswordResetTokenDao createUserPasswordResetToken(UserDao user) throws NoSuchAlgorithmException {
		
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
		
		UserPasswordResetTokenDao userPasswordResetToken = new UserPasswordResetTokenDao(userId, expirationDate, key);
		userPasswordResetToken = userPasswordResetTokenRepository.save(userPasswordResetToken);
		
		return userPasswordResetToken; 
	}
}
