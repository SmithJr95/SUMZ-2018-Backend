package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;

public class UserMapper {
	public static UserDao mapToDao(UserDto userDto) {
		return new UserDao(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getRoles(), false);
	}
	
	public static List<UserDto> mapToDto(List<UserDao> userDao){
		List<UserDto> result = new ArrayList<UserDto>();
		for (UserDao uDao: userDao) {
			result.add(mapToDto(uDao));
		}
		return result;
	}
	
	public static UserDto mapToDto(UserDao uDao) {
		return new UserDto(uDao.getId(), uDao.getEmail(), uDao.getPassword(), uDao.getRoles(), uDao.getIsActive());
	}
	
	public static UserDao mapPutRequestOldToDao(UserPutRequestDto uDto) {
		return new UserDao((long)0, "", uDto.getOldPassword(), null, false);
	}
	
	public static UserDao mapPutRequestNewToDao(UserPutRequestDto uDto) {
		return new UserDao((long)0, "", uDto.getNewPassword(), null, false);
	}
}
