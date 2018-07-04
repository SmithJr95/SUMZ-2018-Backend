package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateDto;

public class TimeSeriesItemDateMapper {
	
	public static TimeSeriesItemDateDto mapDaoToDto(TimeSeriesItemDateDao dao) {
		
		TimeSeriesItemDateDto dto = null; 
		
		if(dao != null) {
			dto = new TimeSeriesItemDateDto(dao.getItemYear(), dao.getItemQuarter());
		}
		
		return dto;
	}
	
	public static TimeSeriesItemDateDao mapDtoToDao(TimeSeriesItemDateDto dto) {
		
		TimeSeriesItemDateDao dao = null;
		
		if(dto != null) {
			dao = new TimeSeriesItemDateDao(dto.getYear(), dto.getQuarter());
		}
				
		return dao;
	}
}
