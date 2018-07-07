package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.FteCompanyValuationResultDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;

public class FteCompanyValuationResultMapper {

	public static FteCompanyValuationResultDto mapDaoToDto(FteCompanyValuationResultDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		FteCompanyValuationResultDto dto = new FteCompanyValuationResultDto(dao.getCompanyValue());
		
		return dto;
	}
	
	public static FteCompanyValuationResultDao mapDtoToDao(FteCompanyValuationResultDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		FteCompanyValuationResultDao dao = new FteCompanyValuationResultDao();
		dao.setCompanyValue(dto.getCompanyValue());
		
		return dao;
	}
}
