package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;

public class UserMapper {
	public static UserDao mapToDao(UserDto userDto) {
		throw new UnsupportedOperationException();
	}
	
	public static List<UserDto> mapToDto(List<UserDao> userDao){
		List<UserDto> result = new ArrayList<UserDto>();
		for (UserDao ud: userDao) {
			result.add(mapToDto(ud));
		}
		return result;
	}
	
	public static UserDto mapToDto(UserDao userDao) {
		throw new UnsupportedOperationException();
	}
}
