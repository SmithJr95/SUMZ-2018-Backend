package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.MultiPeriodAccountingFigureDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureResponseDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.TimeSeriesItemResponseDto;

public class MultiPeriodAccountingFigureMapper {

	public static MultiPeriodAccountingFigureDao mapDtoToDao(MultiPeriodAccountingFigureRequestDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		List<TimeSeriesItemDao> timeSeriesItems = TimeSeriesItemMapper.mapDtoToDao(dto.getTimeSeries());
		String figureName = dto.getFigureName() != null ? dto.getFigureName().name() : null;
		
		MultiPeriodAccountingFigureDao dao = new MultiPeriodAccountingFigureDao(figureName, dto.getIsHistoric(), timeSeriesItems);
		
		return dao;
	}
	
	public static MultiPeriodAccountingFigureResponseDto mapDaoToDto(MultiPeriodAccountingFigureDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		List<TimeSeriesItemResponseDto> timeSeriesItems = TimeSeriesItemMapper.mapDaoToDto(dao.getTimeSeriesItems());
		MultiPeriodAccountingFigureResponseDto dto = new MultiPeriodAccountingFigureResponseDto(dao.getIsHistoric(), timeSeriesItems);
		
		return dto;
	}
}
