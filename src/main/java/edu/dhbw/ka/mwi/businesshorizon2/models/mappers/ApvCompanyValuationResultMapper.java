package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ApvCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;

public class ApvCompanyValuationResultMapper {
	
	public static ApvCompanyValuationResultDto mapDaoToDto(ApvCompanyValuationResultDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		ApvCompanyValuationResultDto dto = new ApvCompanyValuationResultDto(
				dao.getCompanyValue(), 
				dao.getMarketValueTotalAssets(), 
				dao.getTotalLiabilities(), 
				dao.getPresentValueOfCashflows(), 
				dao.getTaxShield());
		
		return dto;
	}
	
	public static ApvCompanyValuationResultDao mapDtoToDao(ApvCompanyValuationResultDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		ApvCompanyValuationResultDao dao = new ApvCompanyValuationResultDao();
		dao.setCompanyValue(dto.getCompanyValue());
		dao.setMarketValueTotalAssets(dto.getMarketValueTotalAssets());
		dao.setPresentValueOfCashflows(dto.getPresentValueOfCashflows());
		dao.setTaxShield(dto.getTaxShield());
		dao.setTotalLiabilities(dto.getTotalLiabilities());
		
		return dao;
	}
}
