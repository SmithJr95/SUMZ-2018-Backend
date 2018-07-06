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
		}
		
		return "Success";
	}
}
