package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.CompanyValueDistributionPointDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;

public class CompanyValueDistributionMapper {
	
	public static CompanyValueDistributionDto mapDaoToDto(List<CompanyValueDistributionPointDao> pointsDao) {
		
		if(pointsDao == null || pointsDao.isEmpty()) {
			return null;
		}
		
		List<Double> xValues = new ArrayList<>();
		List<Double> yValues = new ArrayList<>();
		
		for (int i = 0; i < pointsDao.size(); i++) {
			xValues.add(pointsDao.get(i).getxValue());
			yValues.add(pointsDao.get(i).getyValue());
		}
		
		CompanyValueDistributionDto dto = new CompanyValueDistributionDto(xValues, yValues);
		
		return dto;
	}
	
	public static List<CompanyValueDistributionPointDao> mapDtoToDao(CompanyValueDistributionDto dto){
		
		if(dto == null) {
			return null;
		}
		
		List<CompanyValueDistributionPointDao> daos = new ArrayList<>();
		
		for (int i = 0; i < dto.getxValues().size(); i++) {
			CompanyValueDistributionPointDao dao = new CompanyValueDistributionPointDao();
			dao.setxValue(dto.getxValues().get(i));
			dao.setyValue(dto.getyValues().get(i));
			
			daos.add(dao);
		}
		
		return daos;
	}
}
