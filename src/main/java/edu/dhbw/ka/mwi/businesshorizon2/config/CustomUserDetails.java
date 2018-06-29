package edu.dhbw.ka.mwi.businesshorizon2.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User{
	
	private final long userID;
	
	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, long userID) {
		super(username, password, authorities);
		this.userID = userID;
	}


	public long getUserID() {
		return userID;
	}
}