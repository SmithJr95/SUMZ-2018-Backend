package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.ScenarioDao;

public interface IScenarioRepository extends CrudRepository<ScenarioDao, Long>{

	@Query("SELECT s FROM Scenario s WHERE s.appUser.appUserId=:appUserId")
	List<ScenarioDao> getAll (@Param("appUserId") Long appUserId);
}
