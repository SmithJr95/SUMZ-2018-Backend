package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ApvCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;

public class ApvCompanyValuationResultMapper {
	
	public static ApvCompanyValuationResultDao mapDtoToDao(ApvCompanyValuationResultDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		ApvCompanyValuationResultDao dao = new ApvCompanyValuationResultDao(
				dto.getCompanyValue(), 
				dto.getMarketValueTotalAssets(), 
				dto.getTotalLiabilities(), 
				dto.getMarketValueEquity(), 
				dto.getTaxShield());
		
		return dao;
	}
	
	public static ApvCompanyValuationResultDto mapDtoToDao(ApvCompanyValuationResultDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		ApvCompanyValuationResultDto dto = new ApvCompanyValuationResultDto(
				dao.getCompanyValue(), 
				dao.getMarketValueTotalAssets(), 
				dao.getTotalLiabilities(), 
				dao.getMarketValueEquity(), 
				dao.getTaxShield());
		
		return dto;
	}
}
