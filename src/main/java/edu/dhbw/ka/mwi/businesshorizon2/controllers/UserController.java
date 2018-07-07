package edu.dhbw.ka.mwi.businesshorizon2.controllers;

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

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.UserService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.AppUserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(value = "User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "add a user to the system")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody @Valid AppUserDto userDto, HttpServletRequest request) throws Exception{
		String host = request.getRequestURL().toString();
		userService.addUser(userDto, host);
	}
	
	@ApiOperation(value = "activate a user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
	public void activateUser(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userService.activateUser(token);
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/login";
		
		response.sendRedirect(redirectURL);
	}
	
	@ApiOperation(value = "User forgot password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/forgot", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void passwordForgot(@RequestBody @Valid AppUserDto user, HttpServletRequest request) throws Exception {
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		userService.requestUserPasswordReset(user.getEmail(), redirectURL);
	}
	
	@ApiOperation("check token to reset the password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/forgot/{token}", method = RequestMethod.GET)
	public void checkPasswordResetToken(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String redirectURL = request.getRequestURL().toString();
		redirectURL = redirectURL.replaceAll(request.getRequestURI(), "");
		redirectURL = redirectURL + "/users/reset/" + token;
		
		userService.checkPasswordResetToken(token);
		
		response.sendRedirect(redirectURL + token);
	}
	
	@ApiOperation("reset the password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void resetPassword(@PathVariable("token") String token, @RequestBody @Valid AppUserDto userDto) throws Exception {
		
		userService.resetUserPassword(userDto, token);
	}
	
	@ApiOperation("redirect to the reset password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/reset/{token}", method = RequestMethod.GET)
	public void resetPassword() {
		
	}
	
	@ApiOperation("delete a user from the system")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void deleteUser(@RequestBody @Valid AppUserDto user, @PathVariable Long id) throws Exception {
		userService.deleteUser(user, id);
	}
	
	@ApiOperation("update a user password")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void updateUser(@RequestBody @Valid UserPutRequestDto user, @PathVariable Long id) throws Exception {

		userService.updateUserPassword(user, id);
	}
}
