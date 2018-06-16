package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;


public interface IUserRepository extends CrudRepository<UserDao, Long> {
	UserDao findByEmail(String s);
}
