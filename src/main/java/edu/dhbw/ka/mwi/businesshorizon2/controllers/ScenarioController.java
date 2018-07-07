package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IAccountingFigureCalculationsService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ICompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IScenarioService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.ITimeSeriesPredictionService;
import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

@RestController
@RequestMapping("/scenarios")
public class ScenarioController {
	
	@Autowired
	private IScenarioService scenarioService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public ScenarioResponseDto create(@RequestBody @Valid ScenarioRequestDto scenario) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) auth.getPrincipal();
		
		Long appUserId = userService.getUserId(username);
		
		return scenarioService.createOrUpdateScenario(scenario, appUserId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public ScenarioResponseDto update(@RequestBody @Valid ScenarioRequestDto scenario) {
		
		throw new UnsupportedOperationException();
		/*
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) auth.getPrincipal();
		
		Long appUserId = userService.getUserId(username);
		
		return scenarioService.createOrUpdateScenario(scenario, appUserId);
		*/
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public List<ScenarioResponseDto> getAll () {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) auth.getPrincipal();
		
		Long appUserId = userService.getUserId(username);
		List<ScenarioResponseDto> scenarios = scenarioService.getAll(appUserId);
		
		return scenarios;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public ResponseEntity delete(@PathVariable("id") Long scenarioId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) auth.getPrincipal();
		
		Long appUserId = userService.getUserId(username);
		Boolean success = scenarioService.delete(appUserId, scenarioId);
		
		if(!success) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
