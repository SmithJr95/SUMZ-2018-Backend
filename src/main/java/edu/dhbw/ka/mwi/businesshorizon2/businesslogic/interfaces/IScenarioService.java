package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPutRequestDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

@Service
public interface IScenarioService {
	public void delete(Long scenarioId, Long appUserId);
	public List<ScenarioResponseDto> getAll(Long appUserId);
	public ScenarioResponseDto get(Long scenarioId, Long appUserId);
	public Long create(ScenarioPostRequestDto scenarioDto, Long appUserId);
	public Long update(ScenarioPutRequestDto scenarioDto, Long appUserId);
}
