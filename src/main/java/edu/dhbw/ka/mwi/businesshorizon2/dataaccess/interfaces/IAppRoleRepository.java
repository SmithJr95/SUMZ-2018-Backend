package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppRoleDao;

public interface IAppRoleRepository extends CrudRepository<AppRoleDao, Long> {

}
