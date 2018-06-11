package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IUserService;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.UserDao;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    
    public List<UserDao> findAllUsers() {
        return (List<UserDao>)userRepository.findAll();
    }
    
    public UserDao findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
