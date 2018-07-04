package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppRoleDao;

public class UserDto {

    private Long id;
    private String email;
    private String password;
    private List<AppRoleDao> roles = new ArrayList<>();
    
    public UserDto() { }
    
    public UserDto(Long id, String email, String password, List<AppRoleDao> roles, Boolean isActive) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.roles = roles;
    }
    
  	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<AppRoleDao> getRoles() { return roles; }
    public void setRoles(List<AppRoleDao> roles) { this.roles = roles;}
}
