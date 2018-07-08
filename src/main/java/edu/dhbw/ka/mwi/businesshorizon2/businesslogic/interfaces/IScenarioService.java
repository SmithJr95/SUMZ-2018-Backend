package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

@Service
public interface IScenarioService {
	public Boolean delete(Long appUserId, Long scenarioId);
	public List<ScenarioResponseDto> getAll(Long appUserId);
	public ScenarioResponseDto get(Long scenarioId);
	public Long createOrUpdateScenario(ScenarioRequestDto scenarioDto, Long appUserId);
}
