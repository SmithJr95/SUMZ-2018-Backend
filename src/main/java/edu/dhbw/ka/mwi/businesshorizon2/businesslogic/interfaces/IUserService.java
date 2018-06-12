package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

public interface IUserService {
	public List<UserDao> findAllUsers();
    
    public UserDao findById(int id);
    
    public UserDao findByEmail(String s);
}
