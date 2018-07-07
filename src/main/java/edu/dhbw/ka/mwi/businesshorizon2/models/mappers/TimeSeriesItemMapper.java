package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDateDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemDateResponseDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemResponseDto;

public class TimeSeriesItemMapper {
	
	public static TimeSeriesItemDao mapDtoToDao(TimeSeriesItemRequestDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		TimeSeriesItemDateDao dateDao = TimeSeriesItemDateMapper.mapDtoToDao(dto.getDate());
		TimeSeriesItemDao dao = new TimeSeriesItemDao(dto.getAmount(), dateDao);
		
		return dao;
	}
	
	public static List<TimeSeriesItemDao> mapDtoToDao(List<TimeSeriesItemRequestDto> dtos){
		
		if(dtos == null) {
			return null;
		}
		
		List<TimeSeriesItemDao> daos = new ArrayList<>();
		for (TimeSeriesItemRequestDto dto : dtos) {
			daos.add(mapDtoToDao(dto));
		}
		
		return daos;
	}
	
	public static TimeSeriesItemResponseDto mapDaoToDto(TimeSeriesItemDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		TimeSeriesItemDateResponseDto dateDto = TimeSeriesItemDateMapper.mapDaoToDto(dao.getTimeSeriesItemDate());
		TimeSeriesItemResponseDto dto = new TimeSeriesItemResponseDto(dateDto, dao.getItemAmount());
		
		return dto;
	}
	
	public static List<TimeSeriesItemResponseDto> mapDaoToDto(List<TimeSeriesItemDao> daos){
		
		if(daos == null) {
			return null;
		}
		
		List<TimeSeriesItemResponseDto> dtos = new ArrayList<>();
		for (TimeSeriesItemDao dao : daos) {
			dtos.add(mapDaoToDto(dao));
		}
		
		return dtos;
	}
}
