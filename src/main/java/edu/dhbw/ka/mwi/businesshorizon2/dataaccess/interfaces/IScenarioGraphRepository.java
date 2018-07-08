package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;


public interface IScenarioGraphRepository {
	public Long create(ScenarioDao scenario, Long appUserId);
}
