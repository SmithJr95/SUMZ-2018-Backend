package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

public interface IUserService {
	public List<UserDao> findAllUsers();
    
    public UserDao findByUsername(String username);
}
