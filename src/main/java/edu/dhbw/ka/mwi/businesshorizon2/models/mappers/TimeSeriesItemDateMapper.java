package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateResponseDto;

public class TimeSeriesItemDateMapper {
	
	public static TimeSeriesItemDateResponseDto mapDaoToDto(TimeSeriesItemDateDao dao) {
		
		TimeSeriesItemDateResponseDto dto = null; 
		
		if(dao != null) {
			dto = new TimeSeriesItemDateResponseDto(dao.getItemYear(), dao.getItemQuarter());
		}
		
		return dto;
	}
	
	public static TimeSeriesItemDateDao mapDtoToDao(TimeSeriesItemDateRequestDto dto) {
		
		TimeSeriesItemDateDao dao = null;
		
		if(dto != null) {
			dao = new TimeSeriesItemDateDao(dto.getYear(), dto.getQuarter());
		}
				
		return dao;
	}
}
