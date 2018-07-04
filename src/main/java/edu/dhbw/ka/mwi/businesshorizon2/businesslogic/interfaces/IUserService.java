package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;

public interface IUserService {
	
	public List<AppUserDao> findAllUsers();
    
    public AppUserDao findByEmail(String s);

	void activateUser(String token) throws JsonParseException, JsonMappingException, IOException, Exception;

	UserPasswordResetTokenDao checkPasswordResetToken(String token) throws JsonParseException, JsonMappingException, IOException, Exception;

	void resetUserPassword(AppUserDao user, String tokenStr) throws JsonParseException, JsonMappingException, IOException, Exception;

	AppUserDao addUser(AppUserDao user, String host) throws Exception;

	String requestUserPasswordReset(String email, String host) throws Exception;

	String encodePassword(String password);

	void updateUserPassword(AppUserDao oldUser, AppUserDao newUser, Long userID) throws Exception;

	void deleteUser(AppUserDao user, Long id) throws Exception;
}
