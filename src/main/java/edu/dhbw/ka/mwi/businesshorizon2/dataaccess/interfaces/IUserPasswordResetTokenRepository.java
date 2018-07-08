package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserPasswordResetTokenDao;

public interface IUserPasswordResetTokenRepository extends CrudRepository<UserPasswordResetTokenDao, Long>{

}
