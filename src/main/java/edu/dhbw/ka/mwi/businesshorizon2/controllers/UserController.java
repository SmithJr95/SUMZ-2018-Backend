package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.UserService;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.AppUserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody @Valid AppUserDto userDto, HttpServletRequest request) throws Exception{
		String host = request.getRequestURL().toString();
		userService.addUser(userDto, host);
	}
	
	@RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
	public void activateUser(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userService.activateUser(token);
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/login";
		
		response.sendRedirect(redirectURL);
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void passwordForgot(@RequestBody @Valid AppUserDto user, HttpServletRequest request) throws Exception {
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		userService.requestUserPasswordReset(user.getEmail(), redirectURL);
	}
	
	@RequestMapping(value = "/forgot/{token}", method = RequestMethod.GET)
	public void checkPasswordResetToken(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/users/reset/" + token;
		
		userService.checkPasswordResetToken(token);
		
		response.sendRedirect(redirectURL + token);
	}
	
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void resetPassword(@PathVariable("token") String token, @RequestBody @Valid AppUserDto userDto) throws Exception {
		
		userService.resetUserPassword(userDto, token);
	}
	
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.GET)
	public void resetPassword() {
		
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void deleteUser(@RequestBody @Valid AppUserDto user, @PathVariable Long id) throws Exception {
		userService.deleteUser(user, id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void updateUser(@RequestBody @Valid UserPutRequestDto user, @PathVariable Long id) throws Exception {

		userService.updateUserPassword(user, id);
	}
}
