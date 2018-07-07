package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IAccountingFigureCalculationsService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ITimeSeriesPredictionService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	
	@ApiOperation(value = "create a new scenario for a user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "succesfull operation"),
			@ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 400, message = "something went wrong")
	})
	@RequestMapping(method = RequestMethod.POST)
	public void createScenario(@RequestBody @Valid ScenarioRequestDto scenario) {

	}
	
	@ApiOperation(value = "request a list of all scenarios (according a user)")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "succesfull operation"),
			@ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 400, message = "something went wrong"),
			@ApiResponse(code = 404, message = "record not found")
	})
	@RequestMapping(method = RequestMethod.GET)
	public String getScenario () {
		return "Success";
	}
}
