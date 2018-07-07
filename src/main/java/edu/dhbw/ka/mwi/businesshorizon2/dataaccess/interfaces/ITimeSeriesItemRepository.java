package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.TimeSeriesItemDao;

public interface ITimeSeriesItemRepository extends CrudRepository<TimeSeriesItemDao, Long>{

}
