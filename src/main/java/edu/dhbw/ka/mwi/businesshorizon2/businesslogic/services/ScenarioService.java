package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IAccountingFigureCalculationsService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IScenarioService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ITimeSeriesPredictionService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.mappers.ScenarioMapper;

@Service
public class ScenarioService implements IScenarioService{

	private final Integer numSamples = 5;
	
	@Autowired
	private IAccountingFigureCalculationsService accountingService;
	
	@Autowired
	private ITimeSeriesPredictionService predictionService;
	
	@Autowired
	private ICompanyValuationService companyValuationService;
	
	@Override
	public ScenarioResponseDto createOrUpdateScenario(ScenarioRequestDto scenarioDto, Long appUserId) {
		
		HashMap<MultiPeriodAccountingFigureNames, List<Double>> deterministicAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, List<Double>>();
		
		HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>>();
		
		List<MultiPeriodAccountingFigureRequestDto> nonHistoricAccountingFigures = scenarioDto.getAllMultiPeriodAccountingFigures();
		nonHistoricAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(true));
		
		List<MultiPeriodAccountingFigureRequestDto> historicAccountingFigures = scenarioDto.getAllMultiPeriodAccountingFigures();
		historicAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(false));
		
		boolean isValuationStochastic = !historicAccountingFigures.isEmpty();
		boolean freeCashFlowsProvided = false;
		double effectiveTaxRate = accountingService.calculateEffectiveTaxRate(scenarioDto.getBusinessTaxRate(), scenarioDto.getCorporateTaxRate(), scenarioDto.getSolidaryTaxRate());
		
		for (MultiPeriodAccountingFigureRequestDto figure : nonHistoricAccountingFigures) {
			deterministicAccountingFigures.put(figure.getFigureName(), figure.getTimeSeriesAmountsSortedAscByDate());
			
			if(figure.getFigureName() == MultiPeriodAccountingFigureNames.FreeCashFlows) {
				freeCashFlowsProvided = true;
			}
		}
		if(!freeCashFlowsProvided) {
			for (MultiPeriodAccountingFigureRequestDto figure : historicAccountingFigures) {
				if(figure.getFigureName() == MultiPeriodAccountingFigureNames.FreeCashFlows) {
					freeCashFlowsProvided = true;
					break;
				}
			}
		}
		
		if(isValuationStochastic) {
			predictionService.MakePredictions(historicAccountingFigures, stochasticAccountingFigures, scenarioDto.getPeriods(), numSamples);	
		}	
		
		if(isValuationStochastic) {
			
			List<Double> companyValues = new ArrayList<Double>();
			for (int sampleNum = 1; sampleNum <= numSamples; sampleNum++) {
					
				List<Double> liabilities = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.Liabilities, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
						
				List<Double> freeCashFlows;

				if(freeCashFlowsProvided) {
					freeCashFlows = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.FreeCashFlows, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
				}
				else {
					List<Double> revenues = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.Revenue, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> additionalIncomes = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.AdditionalIncome, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> costOfMaterials = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.CostOfMaterial, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> costOfStaffs = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.CostOfStaff, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> additionalCostss = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.AdditionalCosts, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> depreciations = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.Depreciation, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					List<Double> investments = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.Investments, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);				
					List<Double> divestments = getDeterministicOrStochasticAccountingFigure(MultiPeriodAccountingFigureNames.Divestments, deterministicAccountingFigures, stochasticAccountingFigures, sampleNum);
					
					freeCashFlows = new ArrayList<>();	
					for (int periodNum = 0; periodNum < scenarioDto.getPeriods(); periodNum++) {
						
						double freeCashFlow = accountingService.calculateFreeCashFlow(
								revenues.get(periodNum), 
								additionalIncomes.get(periodNum), 
								costOfMaterials.get(periodNum), 
								costOfStaffs.get(periodNum), 
								additionalCostss.get(periodNum), 
								depreciations.get(periodNum), 
								scenarioDto.getBusinessTaxRate(), 
								scenarioDto.getCorporateTaxRate(), 
								scenarioDto.getSolidaryTaxRate(), 
								investments.get(periodNum), 
								divestments.get(periodNum));
						
						freeCashFlows.add(freeCashFlow);
					}
				}
				
				List<Double> ftes = new ArrayList<Double>();
				for (int periodNum = 0; periodNum < scenarioDto.getPeriods(); periodNum++) {
					double fte;
					
					if(periodNum == scenarioDto.getPeriods() - 1) {
						fte = accountingService.calculateFlowToEquity(freeCashFlows.get(periodNum), liabilities.get(periodNum), liabilities.get(periodNum), scenarioDto.getInterestOnLiabilitiesRate(), effectiveTaxRate);
					}
					else {
						fte = accountingService.calculateFlowToEquity(freeCashFlows.get(periodNum), liabilities.get(periodNum + 1), liabilities.get(periodNum), scenarioDto.getInterestOnLiabilitiesRate(), effectiveTaxRate);
					}
					
					ftes.add(fte);
				}
				
				if(!stochasticAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FlowToEquity)) {
					stochasticAccountingFigures.put(MultiPeriodAccountingFigureNames.FlowToEquity, new HashMap<Integer, List<Double>>());
				}
				
				stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.FlowToEquity).put(sampleNum, ftes);
				
				ApvCompanyValuationResultDto res = companyValuationService.performApvCompanyValuation(
						freeCashFlows, 
						liabilities, 
						scenarioDto.getEquityInterestRate(), 
						scenarioDto.getInterestOnLiabilitiesRate(), 
						effectiveTaxRate);
				
				companyValues.add(res.getCompanyValue());
			}
			
			List<Double> meanFreeCashFlows = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FreeCashFlows) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.FreeCashFlows, scenarioDto.getPeriods());
					
			List<Double> meanLiabilities = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.Liabilities) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.Liabilities, scenarioDto.getPeriods());
					
			List<Double> meanFlowToEquity = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FlowToEquity) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FlowToEquity)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.FlowToEquity, scenarioDto.getPeriods());
			
			ApvCompanyValuationResultDto apvRes = companyValuationService.performApvCompanyValuation(
					meanFreeCashFlows, 
					meanLiabilities, 
					scenarioDto.getEquityInterestRate(), 
					scenarioDto.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			FteCompanyValuationResultDto fteRes = companyValuationService.performFteCompanyValuationResult(
					meanFlowToEquity, 
					meanLiabilities, 
					scenarioDto.getEquityInterestRate(), 
					scenarioDto.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			FcfCompanyValuationResultDto fcfRes = companyValuationService.performFcfCompanyValuationResult(
					meanFreeCashFlows, 
					meanLiabilities, 
					scenarioDto.getEquityInterestRate(), 
					scenarioDto.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			//company value distribution.
			CompanyValueDistributionDto companyValueDistribution = companyValuationService.getCompanyValueDistribution(companyValues);
			
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Double> getDeterministicOrStochasticAccountingFigure(
			MultiPeriodAccountingFigureNames figureName, 
			HashMap<MultiPeriodAccountingFigureNames, List<Double>> deterministicAccountingFigures,
			HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures,
			Integer sampleNum
			) {
		return deterministicAccountingFigures.containsKey(figureName)
			? deterministicAccountingFigures.get(figureName)
			: stochasticAccountingFigures.get(figureName).get(sampleNum);
	}
	
}
