package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.UserDto;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public List<UserDao> findAllUsers() {
    	System.out.println("TEST");
        return (List<UserDao>)userRepository.findAll();
    }
   
	@Override
	public UserDao findByEmail(String s) {
		return userRepository.findByEmail(s);
	}
    
    
}
