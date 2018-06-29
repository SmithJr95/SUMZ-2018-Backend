package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@Entity
@Table(name = "appUser")
public class UserDao{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @Column(name = "isActive")
    private Boolean isActive;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userRole", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<RoleDao> roles;

	public UserDao(Long id, String email, String password, List<RoleDao> roles, boolean isActive) {
		this.id = id;
		this.email = email; 
		this.password = password; 
		this.roles = roles; 
		this.isActive = isActive;
	}
	
	public UserDao() {
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
    
    public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
