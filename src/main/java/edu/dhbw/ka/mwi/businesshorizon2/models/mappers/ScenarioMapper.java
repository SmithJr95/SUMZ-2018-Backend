package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

public class ScenarioMapper {
	
	public static ScenarioDao mapDtoToDao(ScenarioRequestDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		ScenarioDao dao = new ScenarioDao();
		
		dao.setAdditionalCosts(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getAdditionalCosts()));
		dao.setAdditionalIncome(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getAdditionalIncome()));
		dao.setCostOfMaterial(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getCostOfMaterial()));
		dao.setCostOfStaff(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getCostOfStaff()));
		dao.setDepreciation(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getDepreciation()));
		dao.setDivestments(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getDivestments()));
		dao.setFreeCashFlows(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getFreeCashFlows()));
		dao.setInvestments(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getInvestments()));
		dao.setLiabilities(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getLiabilities()));
		dao.setRevenue(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getRevenue()));
		
		dao.setEquityInterestRate(dto.getEquityInterestRate());
		dao.setInterestOnLiabilitiesRate(dto.getInterestOnLiabilitiesRate());
		dao.setForecastPeriods(dto.getPeriods());
		dao.setBusinessTaxRate(dto.getBusinessTaxRate());
		dao.setCorporateTaxRate(dto.getCorporateTaxRate());
		dao.setScenarioDescription(dto.getScenarioDescription());
		dao.setScenarioName(dto.getScenarioName());
		dao.setSolidaryTaxRate(dto.getSolidaryTaxRate());
		
		return dao;
	}
	
	public static ScenarioResponseDto mapDaoToDto(ScenarioDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		ScenarioResponseDto dto = new ScenarioResponseDto();
		
		dto.setAdditionalCosts(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getAdditionalCosts()));
		dto.setAdditionalIncome(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getAdditionalIncome()));
		dto.setCostOfMaterial(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getCostOfMaterial()));
		dto.setCostOfStaff(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getCostOfStaff()));
		dto.setDepreciation(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getDepreciation()));
		dto.setDivestments(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getDivestments()));
		dto.setFreeCashFlows(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getFreeCashFlows()));
		dto.setInvestments(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getInvestments()));
		dto.setLiabilities(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getLiabilities()));
		dto.setRevenue(MultiPeriodAccountingFigureMapper.mapDaoToDto(dao.getRevenue()));
		
		dto.setBusinessTaxRate(dao.getBusinessTaxRate());
		dto.setCorporateTaxRate(dao.getCorporateTaxRate());
		dto.setScenarioDescription(dao.getScenarioDescription());
		dto.setScenarioName(dao.getScenarioName());
		dto.setSolidaryTaxRate(dao.getSolidaryTaxRate());
		dto.setEquityInterestRate(dao.getEquityInterestRate());
		dto.setPeriods(dao.getForecastPeriods());
		dto.setInterestOnLiabilitiesRate(dto.getInterestOnLiabilitiesRate());
		
		return dto;
	}
}
