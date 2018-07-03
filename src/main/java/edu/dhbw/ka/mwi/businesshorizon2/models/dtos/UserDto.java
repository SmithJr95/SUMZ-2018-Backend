package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.RoleDao;

public class UserDto {

    private Long id;
    
    @Email
    private String email;
    
    //at least 6 characters, maximum 20 
    //must contain one digit 0..9 
    //must contain 1 uppercase & 1 lowercase character 
    //must contain one special symbol from @#$%
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
    private String password;
    
    private List<RoleDao> roles;
    
    public UserDto(Long id, String email, String password, List<RoleDao> roles, Boolean isActive) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.roles = roles;
    }
    
    public UserDto() {
    	
    }

  	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDao> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDao> roles) {
        this.roles = roles;
    }
}
