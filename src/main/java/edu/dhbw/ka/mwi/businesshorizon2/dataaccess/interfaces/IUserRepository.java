package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;


public interface IUserRepository extends CrudRepository<UserDao, Integer> {
	UserDao findById(int id);
	
	UserDao findByEmail(String s);
}
