package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IScenarioService;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigure;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.MultiPeriodAccountingFigureNames;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.PredictionRequestTimeSeries;
import edu.dhbw.ka.mwi.businesshorizon2.models.common.PredictionResponseTimeSeries;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.PredictionRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.PredictionResponseDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

@RestController
@RequestMapping("/scenarios")
public class ScenarioController {
	//@Autowired
	//private IScenarioService scenarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void createScenario(@RequestBody @Valid ScenarioPostRequestDto scenario) {
		//System.out.println(scenario);
		
		final Integer numSamples = 5;
		
		HashMap<MultiPeriodAccountingFigureNames, List<Double>> deterministicAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, List<Double>>();
		
		HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>> stochasticAccountingFigures = 
				new HashMap<MultiPeriodAccountingFigureNames, HashMap<Integer, List<Double>>>();
		
		List<MultiPeriodAccountingFigure> nonHistoricAccountingFigures = scenario.getAllMultiPeriodAccountingFigures();
		nonHistoricAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(true));
		
		List<MultiPeriodAccountingFigure> historicAccountingFigures = scenario.getAllMultiPeriodAccountingFigures();
		historicAccountingFigures.removeIf(x -> x == null || x.getTimeSeries() == null || x.getIsHistoric() == null || x.getIsHistoric().equals(false));
		
		boolean isValuationStochastic = !historicAccountingFigures.isEmpty();
		boolean freeCashFlowsProvided = false;
		
		for (MultiPeriodAccountingFigure figure : nonHistoricAccountingFigures) {
			deterministicAccountingFigures.put(figure.getFigureName(), figure.getTimeSeriesAmountsSortedAscByDate());
			
			if(figure.getFigureName() == MultiPeriodAccountingFigureNames.FreeCashFlows) {
				freeCashFlowsProvided = true;
			}
		}
		if(!freeCashFlowsProvided) {
			for (MultiPeriodAccountingFigure figure : historicAccountingFigures) {
				if(figure.getFigureName() == MultiPeriodAccountingFigureNames.FreeCashFlows) {
					freeCashFlowsProvided = true;
					break;
				}
			}
		}
		
		if(isValuationStochastic) {
			List<PredictionRequestTimeSeries> timeSeries = new ArrayList<PredictionRequestTimeSeries>();
			Double[] amountsArr = new Double[historicAccountingFigures.size()];
			
			for (MultiPeriodAccountingFigure figure : historicAccountingFigures) {
				timeSeries.add(new PredictionRequestTimeSeries(figure.getFigureName(), figure.getTimeSeriesAmountsSortedAscByDate().toArray(amountsArr)));
			}
				
			PredictionRequestDto request = new PredictionRequestDto(timeSeries, scenario.getPeriods(), numSamples);
			
			System.out.println("-----------------------REQUEST-----------------------");
			System.out.println(request);
			
			String uri = "http://localhost:5000/predict";
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<PredictionRequestDto> x = new HttpEntity<>(request);
			
			PredictionResponseDto result = restTemplate.postForObject(uri, x, PredictionResponseDto.class);
				
			System.out.println("-----------------------RESPONSE-----------------------");
			System.out.println(result);
			
			for (PredictionResponseTimeSeries ts : result.getTimeSeries()) {
				MultiPeriodAccountingFigureNames name = MultiPeriodAccountingFigureNames.valueOf(ts.getId());
				stochasticAccountingFigures.put(name, new HashMap<Integer, List<Double>>());
				
				for (int i = 0; i < numSamples; i++) {
					stochasticAccountingFigures.get(name).put(i + 1, Arrays.asList(ts.getValues()[i]));
				}				
			}
			
			for (MultiPeriodAccountingFigureNames key : stochasticAccountingFigures.keySet()) {
				System.out.println(stochasticAccountingFigures.get(key));
			}
		}	
		
		if(isValuationStochastic && freeCashFlowsProvided) {
			
			List<Double> companyValues = new ArrayList<Double>();
			for (int i = 1; i <= numSamples; i++) {
				
				List<Double> freeCashFlows = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.FreeCashFlows) 
						? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows)
						: stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.FreeCashFlows).get(i);
						
				List<Double> interestOnLiabilities = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.InterestOnLiabilities)
						? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.InterestOnLiabilities)
						: stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.InterestOnLiabilities).get(i);
						
				List<Double> liabilites = deterministicAccountingFigures.containsKey(MultiPeriodAccountingFigureNames.Liabilities)
						? deterministicAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities)
						: stochasticAccountingFigures.get(MultiPeriodAccountingFigureNames.Liabilities).get(i);
						
				//double fte = 
			}
		}
		
		
	} 
}
