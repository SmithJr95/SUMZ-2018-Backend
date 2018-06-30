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

public interface IUserService {
	public List<UserDao> findAllUsers();
    
    public UserDao findByEmail(String s);

	UserDao addUser(UserDao user) throws MessagingException, JsonProcessingException, NoSuchAlgorithmException, UnsupportedEncodingException;

	void activateUser(String token) throws JsonParseException, JsonMappingException, IOException;

	String resetUserPassword(String email) throws NoSuchAlgorithmException, JsonProcessingException, MessagingException;
}
