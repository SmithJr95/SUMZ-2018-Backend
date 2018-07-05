package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.AppRoleDao;


public class AppUserDto {

    private Long id;
    
    @Email
    private String email;
    
    //at least 6 characters, maximum 20 
    //must contain one digit 0..9 
    //must contain 1 uppercase & 1 lowercase character 
    //must contain one special symbol from @#$%
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
    private String password;
        
    private Boolean isActive;
    
    private List<AppRoleDao> roles = new ArrayList<>();
    
    public AppUserDto() { }
    
    public AppUserDto(Long id, String email, String password, List<AppRoleDao> roles, Boolean isActive) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.setRoles(roles);
    	this.setIsActive(isActive);
    }
    
  	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<AppRoleDao> getRoles() {
		return roles;
	}

	public void setRoles(List<AppRoleDao> roles) {
		this.roles = roles;
	}
    
    

}
