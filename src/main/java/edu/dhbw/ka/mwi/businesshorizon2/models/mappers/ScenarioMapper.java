package edu.dhbw.ka.mwi.businesshorizon2.models.mappers;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioResponseDto;

public class ScenarioMapper {
	
	public static ScenarioResponseDto mapDaoToDto(ScenarioDao dao) {
		
		if(dao == null) {
			return null;
		}
		
		ScenarioResponseDto dto = new ScenarioResponseDto();
		
		return dto;
	}
}
