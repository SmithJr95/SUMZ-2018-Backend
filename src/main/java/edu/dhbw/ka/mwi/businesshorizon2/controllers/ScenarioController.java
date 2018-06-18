package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IScenarioService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

@RestController
@RequestMapping("/scenarios")
public class ScenarioController {
	//@Autowired
	//private IScenarioService scenarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void createScenario(ScenarioPostRequestDto scenario, BindingResult bindingResult) {
		System.out.println("Hallo");
	} 
}
