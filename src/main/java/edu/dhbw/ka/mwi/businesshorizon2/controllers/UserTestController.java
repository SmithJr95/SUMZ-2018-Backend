package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.UserService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.AppUserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.UserMapper;

@RestController
@RequestMapping("/users/test")
public class UserTestController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AppUserDto> getAllUsers(){
		return UserMapper.mapToDto(userService.findAllUsers());
	}

}
