package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.config.CustomUserDetailsConfig;
import edu.dhbw.ka.mwi.businesshorizon2.dataaccess.interfaces.IAppUserRepository;
import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppUserDao;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private IAppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	
        AppUserDao user = userRepository.findByEmail(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }
        
        if(!user.getIsActive()) {
        	throw new DisabledException(String.format("The account for username %s is not active.", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getAppRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new CustomUserDetailsConfig(user.getEmail(), user.getAppUserPassword(), authorities, user.getAppUserId());

        return userDetails;
    }
}
