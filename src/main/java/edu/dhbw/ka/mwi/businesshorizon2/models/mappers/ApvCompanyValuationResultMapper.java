package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ApvCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;

public class ApvCompanyValuationResultMapper {
	
	public static ApvCompanyValuationResultDto mapDtoToDao(ApvCompanyValuationResultDao dao) {
		
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
}
