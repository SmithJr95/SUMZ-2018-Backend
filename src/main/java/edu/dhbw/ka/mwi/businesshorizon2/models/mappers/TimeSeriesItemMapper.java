package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDto;

public class TimeSeriesItemMapper {
	
	public static TimeSeriesItemDao mapDtoToDao(TimeSeriesItemDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		TimeSeriesItemDateDao dateDao = TimeSeriesItemDateMapper.mapDtoToDao(dto.getDate());
		TimeSeriesItemDao dao = new TimeSeriesItemDao(dto.getAmount(), dateDao);
		
		return dao;
	}
	
	public static List<TimeSeriesItemDao> mapDtoToDao(List<TimeSeriesItemDto> dtos){
		
		if(dtos == null) {
			return null;
		}
		
		List<TimeSeriesItemDao> daos = new ArrayList<>();
		for (TimeSeriesItemDto dto : dtos) {
			daos.add(mapDtoToDao(dto));
		}
		
		return daos;
	}
	
	public static TimeSeriesItemDto mapDaoToDto(TimeSeriesItemDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		TimeSeriesItemDateDto dateDto = TimeSeriesItemDateMapper.mapDaoToDto(dao.getTimeSeriesItemDate());
		TimeSeriesItemDto dto = new TimeSeriesItemDto(dateDto, dao.getItemAmount());
		
		return dto;
	}
	
	public static List<TimeSeriesItemDto> mapDaoToDto(List<TimeSeriesItemDao> daos){
		
		if(daos == null) {
			return null;
		}
		
		List<TimeSeriesItemDto> dtos = new ArrayList<>();
		for (TimeSeriesItemDao dao : daos) {
			dtos.add(mapDaoToDto(dao));
		}
		
		return dtos;
	}
}
