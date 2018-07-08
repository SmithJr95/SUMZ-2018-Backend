package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.AppUserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;

@Service
public interface IUserService {
	
	public List<AppUserDao> findAllUsers();
    
    public AppUserDao findByEmail(String s);

	void activateUser(String token) throws JsonParseException, JsonMappingException, IOException, Exception;

	UserPasswordResetTokenDao checkPasswordResetToken(String token) throws JsonParseException, JsonMappingException, IOException, Exception;

	String requestUserPasswordReset(String email, String host) throws Exception;

	String encodePassword(String password);

	AppUserDao addUser(AppUserDto userDto, String host) throws Exception;

	void resetUserPassword(@Valid AppUserDto userDto, String tokenStr) throws Exception;

	void deleteUser(@Valid AppUserDto userDto, Long id) throws Exception;

	void updateUserPassword(UserPutRequestDto user, Long userID) throws Exception;

	Long getUserId(String username);
}
