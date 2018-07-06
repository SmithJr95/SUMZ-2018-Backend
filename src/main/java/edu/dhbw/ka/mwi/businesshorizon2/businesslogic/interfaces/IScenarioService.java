package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

public interface IScenarioService {
	public ScenarioResponseDto createOrUpdateScenario(ScenarioRequestDto scenarioDto, Long appUserId);
	public ScenarioResponseDto deleteScenario(Long appUserId);
}
