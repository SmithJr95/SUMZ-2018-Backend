package edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserDao, Long> {
	UserDao findByUsername(String username);
}
