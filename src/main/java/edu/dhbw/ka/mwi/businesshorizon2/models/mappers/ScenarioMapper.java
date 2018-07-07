package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.MultiPeriodAccountingFigureDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureResponseDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

public class ScenarioMapper {
	
	public static ScenarioDao mapDtoToDao(ScenarioRequestDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		ScenarioDao dao = new ScenarioDao();
		List<MultiPeriodAccountingFigureDao> multiPeriodAccountingFigures = new ArrayList<>();
		
		for(int i = 0; i < dto.getAllMultiPeriodAccountingFigures().size(); i ++) {
			if(dto.getAllMultiPeriodAccountingFigures().get(i) != null) {
				multiPeriodAccountingFigures.add(MultiPeriodAccountingFigureMapper.mapDtoToDao(dto.getAllMultiPeriodAccountingFigures().get(i)));
			}	
		}
		
		dao.setEquityInterestRate(dto.getEquityInterestRate());
		dao.setInterestOnLiabilitiesRate(dto.getInterestOnLiabilitiesRate());
		dao.setForecastPeriods(dto.getPeriods());
		dao.setBusinessTaxRate(dto.getBusinessTaxRate());
		dao.setCorporateTaxRate(dto.getCorporateTaxRate());
		dao.setScenarioDescription(dto.getScenarioDescription());
		dao.setScenarioName(dto.getScenarioName());
		dao.setSolidaryTaxRate(dto.getSolidaryTaxRate());
		
		dao.setMultiPeriodAccountingFigures(multiPeriodAccountingFigures);
		
		return dao;
	}
	
	public static List<ScenarioResponseDto> mapDaoToDto(List<ScenarioDao> daos){
		
		if(daos == null) {
			return null;
		}
		
		List<ScenarioResponseDto> dtos = new ArrayList<>();
		
		for(ScenarioDao dao : daos) {
			if(dao != null) {
				dtos.add(mapDaoToDto(dao));
			}
		}
		
		return dtos;
	}
	
	public static ScenarioResponseDto mapDaoToDto(ScenarioDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		ScenarioResponseDto dto = new ScenarioResponseDto();
		
		dto.setAdditionalIncome(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.AdditionalIncome));
		dto.setAdditionalCosts(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.AdditionalCosts));
		dto.setCostOfMaterial(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.CostOfMaterial));
		dto.setCostOfStaff(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.CostOfStaff));
		dto.setDepreciation(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.Depreciation));
		dto.setDivestments(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.Divestments));
		dto.setFreeCashFlows(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.FreeCashFlows));
		dto.setInvestments(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.Investments));
		dto.setLiabilities(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.Liabilities));
		dto.setRevenue(selectMultiPeriodAccountingFigure(dao.getMultiPeriodAccountingFigures(), MultiPeriodAccountingFigureNames.Revenue));
		
		dto.setBusinessTaxRate(dao.getBusinessTaxRate());
		dto.setCorporateTaxRate(dao.getCorporateTaxRate());
		dto.setScenarioDescription(dao.getScenarioDescription());
		dto.setScenarioName(dao.getScenarioName());
		dto.setSolidaryTaxRate(dao.getSolidaryTaxRate());
		dto.setEquityInterestRate(dao.getEquityInterestRate());
		dto.setPeriods(dao.getForecastPeriods());
		dto.setInterestOnLiabilitiesRate(dao.getInterestOnLiabilitiesRate());
		
		dto.setApvValuationResult(ApvCompanyValuationResultMapper.mapDaoToDto(dao.getApvCompanyValuationResultDao()));
		dto.setFteValuationResult(FteCompanyValuationResultMapper.mapDaoToDto(dao.getFteCompanyValuationResultDao()));
		dto.setFcfValuationResult(FcfCompanyValuationResultMapper.mapDaoToDto(dao.getFcfCompanyValuationResultDao()));
		
		dto.setCompanyValueDistribution(CompanyValueDistributionMapper.mapDaoToDto(dao.getCompanyValueDistributionPoints()));
		
		dto.setId(dao.getScenarioId());
		
		if(dao.getCompanyValueDistributionPoints() != null && !dao.getCompanyValueDistributionPoints().isEmpty()) {
			dto.setStochastic(true);
		}
		else {
			dto.setStochastic(false);
		}
		
		return dto;
	}
	
	private static MultiPeriodAccountingFigureResponseDto selectMultiPeriodAccountingFigure(List<MultiPeriodAccountingFigureDao> figures, MultiPeriodAccountingFigureNames figureName) {
		
		Optional<MultiPeriodAccountingFigureDao> figure = figures
			.stream()
			.filter(x -> x.getFigureName().equals(figureName.name()))
			.findFirst();
		
		if(figure.isPresent()) {
			System.out.println(figure.get().getFigureName());
			return MultiPeriodAccountingFigureMapper.mapDaoToDto(figure.get());
		}
		
		return null;
	}
}
