package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FcfCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;

public class FcfCompanyValuationResultMapper {
	
	public static FcfCompanyValuationResultDto mapDaoToDto(FcfCompanyValuationResultDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		FcfCompanyValuationResultDto dto = new FcfCompanyValuationResultDto(
				dao.getCompanyValue(), 
				dao.getMarketValueTotalAssets(), 
				dao.getTotalLiabilities());
		
		return dto;
	}
	
	public static FcfCompanyValuationResultDao mapDtoToDao(FcfCompanyValuationResultDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		FcfCompanyValuationResultDao dao = new FcfCompanyValuationResultDao();
		dao.setCompanyValue(dto.getCompanyValue());
		dao.setMarketValueTotalAssets(dto.getMarketValueTotalAssets());
		dao.setTotalLiabilities(dto.getTotalLiabilities());
		
		return dao;
	}
}
