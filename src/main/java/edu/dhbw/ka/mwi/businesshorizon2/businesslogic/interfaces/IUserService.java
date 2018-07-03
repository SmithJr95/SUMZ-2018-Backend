package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.mail.MessagingException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;

public interface IUserService {
	public List<UserDao> findAllUsers();
    
    public UserDao findByEmail(String s);

	void activateUser(String token) throws JsonParseException, JsonMappingException, IOException;

	UserPasswordResetTokenDao checkPasswordResetToken(String token) throws JsonParseException, JsonMappingException, IOException, Exception;

	void resetUserPassword(UserDao user, String tokenStr) throws JsonParseException, JsonMappingException, IOException, Exception;

	UserDao addUser(UserDao user, String host) throws Exception;

	String requestUserPasswordReset(String email, String host) throws Exception;

	String encodePassword(String password);
}
