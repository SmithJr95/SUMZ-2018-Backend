package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

public interface IScenarioService {
	public Boolean delete(Long appUserId, Long scenarioId);
	public List<ScenarioResponseDto> getAll(Long appUserId);
	public ScenarioResponseDto createOrUpdateScenario(ScenarioRequestDto scenarioDto, Long appUserId);
}
