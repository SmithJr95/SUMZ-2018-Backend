package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.util.List;

import edu.dhbw.ka.mwi.businesshorizon2.models.daos.RoleDao;

public class UserDto {

    private Long id;
    private String email;
    private String password;
    private List<RoleDao> roles;
    
    public UserDto(Long id, String email, String password, List<RoleDao> roles) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.roles = roles;
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
