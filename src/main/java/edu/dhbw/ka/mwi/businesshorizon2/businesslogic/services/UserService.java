package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    
    public List<UserDao> findAllUsers() {
        return (List<UserDao>)userRepository.findAll();
    }
    
    public UserDao findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
