package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;

public interface IScenarioGraphRepository {
	public ScenarioDao createOrUpdate(ScenarioDao scenario, Long appUserId);
}
