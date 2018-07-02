package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.UserService;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public Collection<UserDto> getAllUsers(){
		return UserMapper.mapToDto(userService.findAllUsers());
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDto addUser(@RequestBody UserDto userDto) throws Exception{
		return UserMapper.mapToDto(userService.addUser(UserMapper.mapToDao(userDto)));
	}
	
	@RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
	public void activateUser(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException{
		userService.activateUser(token);
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/login";
		
		response.sendRedirect(redirectURL);
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public void passwordForgot(@RequestBody UserDto user) throws Exception {
		userService.requestUserPasswordReset(UserMapper.mapToDao(user).getEmail());
	}
	
	@RequestMapping(value = "/forgot/{token}", method = RequestMethod.GET)
	public void checkPasswordResetToken(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/users/reset/" + token;
		
		userService.checkPasswordResetToken(token);
		
		response.sendRedirect(redirectURL + token);
	}
	
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.POST)
	public void resetPassword(@PathVariable("token") String token, @RequestBody UserDto userDto) throws Exception {
		UserDao user = UserMapper.mapToDao(userDto); 
		userService.resetUserPassword(user, token);
	}
	
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.GET)
	public void resetPassword() {
		
	}
}
