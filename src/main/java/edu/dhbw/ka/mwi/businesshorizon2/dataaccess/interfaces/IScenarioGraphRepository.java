package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;


public interface IScenarioGraphRepository {
	public Long createOrUpdate(ScenarioDao scenario, Long appUserId);
}
