package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserPutRequestDto;

public class UserMapper {
	public static AppUserDao mapToDao(UserDto userDto) {
		if(userDto == null) {
			return null;
		}
		
		return new AppUserDao(userDto.getId(), userDto.getEmail(), userDto.getPassword(), userDto.getRoles(), false);
	}
	
	public static List<UserDto> mapToDto(List<AppUserDao> userDao){
		if(userDao == null) {
			return null;
		}
		
		List<UserDto> result = new ArrayList<UserDto>();
		for (AppUserDao uDao: userDao) {
			result.add(mapToDto(uDao));
		}
		return result;
	}
	
	public static UserDto mapToDto(AppUserDao uDao) {
		if(uDao == null) {
			return null;
		}
		
		return new UserDto(uDao.getAppUserId(), uDao.getEmail(), uDao.getAppUserPassword(), uDao.getAppRoles(), uDao.getIsActive());
	}
	
	public static AppUserDao mapPutRequestOldToDao(UserPutRequestDto uDto) {
		
		if(uDto == null) {
			return null;
		}
		
		AppUserDao dao = new AppUserDao(uDto.getOldPassword());
		
		return dao;
	}
	
	public static AppUserDao mapPutRequestNewToDao(UserPutRequestDto uDto) {
		
		if(uDto == null) {
			return null;
		}
		
		AppUserDao dao = new AppUserDao(uDto.getNewPassword());
		
		return dao;
	}
}
