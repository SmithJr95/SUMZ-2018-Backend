package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;

public class UserMapper {
	public static AppUserDao mapToDao(UserDto userDto) {
		return new AppUserDao(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getRoles(), false);
	}
	
	public static List<UserDto> mapToDto(List<AppUserDao> userDao){
		List<UserDto> result = new ArrayList<UserDto>();
		for (AppUserDao uDao: userDao) {
			result.add(mapToDto(uDao));
		}
		return result;
	}
	
	public static UserDto mapToDto(AppUserDao uDao) {
		return new UserDto(uDao.getAppUserId(), uDao.getEmail(), uDao.getAppUserPassword(), uDao.getAppRoles(), uDao.getIsActive());
	}
	
	public static UserDao mapPutRequestOldToDao(UserPutRequestDto uDto) {
		return new UserDao((long)0, "", uDto.getOldPassword(), null, false);
	}
	
	public static UserDao mapPutRequestNewToDao(UserPutRequestDto uDto) {
		return new UserDao((long)0, "", uDto.getNewPassword(), null, false);
	}
}
