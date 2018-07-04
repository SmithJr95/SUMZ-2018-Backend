package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IScenarioRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;

@RestController
@RequestMapping("/scenariotest")
public class ScenarioTestController {
	
	@Autowired
	private IScenarioRepository scenarioRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getScenario () {
		
		Optional<ScenarioDao> scenario = scenarioRepository.findById((long) 1);
		if(scenario.isPresent()) {
			System.out.println(scenario.get().getScenarioName());
			System.out.println(scenario.get().getScenarioDescription());
			System.out.println(scenario.get().getApvCompanyValuationResultDao().getMarketValueTotalAssets());
			System.out.println(scenario.get().getFcfCompanyValuationResultDao().getMarketValueTotalAssets());
			System.out.println(scenario.get().getFteCompanyValuationResultDao().getCompanyValue());
			System.out.println(scenario.get().getFreeCashFlows().getFigureName());
			System.out.println(scenario.get().getCostOfStaff() != null ? scenario.get().getCostOfStaff().getFigureName() : "isnull.");
			scenario.get().getCompanyValueDistributionPoints().forEach(x -> System.out.println(x.getxValue()));
			scenario.get().getCompanyValueDistributionPoints().forEach(x -> System.out.println(x.getScenario().getScenarioId()));
			scenario.get().getCostOfStaff().getTimeSeriesItems().forEach(x -> System.out.println(x.getTimeSeriesItemDate().getItemQuarter()));
		}
		
		return "Success";
	}
}
