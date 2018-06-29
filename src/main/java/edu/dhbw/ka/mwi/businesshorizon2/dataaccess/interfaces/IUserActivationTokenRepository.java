package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserActivationTokenDao;

public interface IUserActivationTokenRepository extends CrudRepository<UserActivationTokenDao, Long>{

}
