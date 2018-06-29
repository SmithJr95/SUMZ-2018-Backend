package edu.dhbw.ka.mwi.businesshorizon2.controllers;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.mail.MessagingException;

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
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public Collection<UserDto> getAllUsers(){
		return UserMapper.mapToDto(userService.findAllUsers());
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDto addUser(@RequestBody UserDto userDto) throws MessagingException, JsonProcessingException, NoSuchAlgorithmException, UnsupportedEncodingException{
		return UserMapper.mapToDto(userService.addUser(UserMapper.mapToDao(userDto)));
	}
	
	@RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
	public void activateUser(@PathVariable("token") String token) throws JsonParseException, JsonMappingException, IOException{
		userService.activateUser(token);
	}
	
}
