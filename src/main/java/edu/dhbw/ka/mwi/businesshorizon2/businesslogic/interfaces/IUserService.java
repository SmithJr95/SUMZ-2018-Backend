package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

public interface IUserService {
	public List<UserDao> findAllUsers();
    
    public UserDao findByEmail(String email);
}
