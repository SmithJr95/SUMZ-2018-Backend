package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IAccountingFigureCalculationsService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ITimeSeriesPredictionService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IScenarioRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.MultiPeriodAccountingFigureRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

@RestController
@RequestMapping("/scenarios")
public class ScenarioController {
	//@Autowired
	//private IScenarioService scenarioService;

	@Autowired
	private IAccountingFigureCalculationsService accountingService;
	
	@Autowired
	private ICompanyValuationService companyValuationService;
	
	@Autowired
	private ITimeSeriesPredictionService predictionService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void createScenario(@RequestBody @Valid ScenarioPostRequestDto scenario) {
		//System.out.println(scenario);
		
		final Integer numSamples = 5;
		
		HashMap<MultiPeriodAccountingFigureNames, List<Double>> deterministicAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, List<Double>>();
		
		HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>>();
		
		List<MultiPeriodAccountingFigureRequestDto> nonHistoricAccountingFigures = scenario.getAllMultiPeriodAccountingFigures();
		nonHistoricAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(true));
		
		List<MultiPeriodAccountingFigureRequestDto> historicAccountingFigures = scenario.getAllMultiPeriodAccountingFigures();
		historicAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(false));
		
		boolean isValuationStochastic = !historicAccountingFigures.isEmpty();
		boolean freeCashFlowsProvided = false;
		double effectiveTaxRate = accountingService.calculateEffectiveTaxRate(scenario.getBusinessTaxRate(), scenario.getCorporateTaxRate(), scenario.getSolidaryTaxRate());
		
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
			predictionService.MakePredictions(historicAccountingFigures, stochasticAccountingFigures, scenario.getPeriods(), numSamples);	
		}	
		
		if(isValuationStochastic && freeCashFlowsProvided) {
			System.out.println("isValuationStochastic && freeCashFlowsProvided");
			
			List<Double> companyValues = new ArrayList<Double>();
			for (int sampleNum = 1; sampleNum <= numSamples; sampleNum++) {
				
				List<Double> freeCashFlows = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FreeCashFlows) 
						? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows)
						: stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows).get(sampleNum);
						
				List<Double> liabilities = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.Liabilities)
						? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities)
						: stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities).get(sampleNum);
						
				List<Double> ftes = new ArrayList<Double>();
						
				for (int periodNum = 0; periodNum < scenario.getPeriods(); periodNum++) {
					double fte;
					
					if(periodNum == scenario.getPeriods() - 1) {
						fte = accountingService.calculateFlowToEquity(freeCashFlows.get(periodNum), liabilities.get(periodNum), liabilities.get(periodNum), scenario.getInterestOnLiabilitiesRate(), effectiveTaxRate);
					}
					else {
						fte = accountingService.calculateFlowToEquity(freeCashFlows.get(periodNum), liabilities.get(periodNum + 1), liabilities.get(periodNum), scenario.getInterestOnLiabilitiesRate(), effectiveTaxRate);
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
						scenario.getEquityInterestRate(), 
						scenario.getInterestOnLiabilitiesRate(), 
						effectiveTaxRate);
				
				companyValues.add(res.getCompanyValue());
			}
			
			List<Double> meanFreeCashFlows = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FreeCashFlows) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.FreeCashFlows, scenario.getPeriods());
					
			List<Double> meanLiabilities = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.Liabilities) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.Liabilities, scenario.getPeriods());
					
			List<Double> meanFlowToEquity = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FlowToEquity) 
					? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FlowToEquity)
					: accountingService.getMeanAccountingFigureValues(stochasticAccountingFigures, MultiPeriodAccountingFigureNames.FlowToEquity, scenario.getPeriods());
			
			ApvCompanyValuationResultDto apvRes = companyValuationService.performApvCompanyValuation(
					meanFreeCashFlows, 
					meanLiabilities, 
					scenario.getEquityInterestRate(), 
					scenario.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			FteCompanyValuationResultDto fteRes = companyValuationService.performFteCompanyValuationResult(
					meanFlowToEquity, 
					meanLiabilities, 
					scenario.getEquityInterestRate(), 
					scenario.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			FcfCompanyValuationResultDto fcfRes = companyValuationService.performFcfCompanyValuationResult(
					meanFreeCashFlows, 
					meanLiabilities, 
					scenario.getEquityInterestRate(), 
					scenario.getInterestOnLiabilitiesRate(), 
					effectiveTaxRate);
			
			//company value distribution.
			CompanyValueDistributionDto companyValueDistribution = companyValuationService.getCompanyValueDistribution(companyValues);
		}	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getScenario () {
		return "Success";
	}
}
