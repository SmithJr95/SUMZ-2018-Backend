package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@Entity(name = "AppUser")
@Table(name = "AppUser")
public class AppUserDao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppUserId")
    private Long appUserId;

    @Column(name = "Email", columnDefinition = "nvarchar")
    private String email;

    @Column(name = "AppUserPassword", columnDefinition = "nvarchar")
    private String appUserPassword;
    
    @Column(name = "IsActive")
    private Boolean isActive;

    //, cascade = {CascadeType.ALL}
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "UserRole", 
    		joinColumns = @JoinColumn(name = "AppUserId", referencedColumnName = "AppUserId"),
            inverseJoinColumns = @JoinColumn(name = "AppRoleId", referencedColumnName = "AppRoleId"))
    private List<AppRoleDao> appRoles = new ArrayList<>();

	public AppUserDao() { }

	public AppUserDao(String appUserPassword) {
		this.appUserPassword = appUserPassword;
	}
	
	public AppUserDao(Long appUserId, String email, String appUserPassword, List<AppRoleDao> appRoles, boolean isActive) {
		this.appUserId = appUserId;
		this.email = email; 
		this.appUserPassword = appUserPassword; 
		this.appRoles = appRoles; 
		this.isActive = isActive;
	}
	
	@OneToMany(mappedBy="appUser")
	List<UserActivationTokenDao> userActivationTokens = new ArrayList<UserActivationTokenDao>();
	
	@OneToMany(mappedBy="appUser")
	List<UserPasswordResetTokenDao> userPasswordResetTokens = new ArrayList<UserPasswordResetTokenDao>();
	
	@OneToMany(mappedBy="appUser")
	List<ScenarioDao> scenarios = new ArrayList<ScenarioDao>();
	
	public Long getAppUserId() { return appUserId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAppUserPassword() { return appUserPassword; }
    public void setPassword(String appUserPassword) { this.appUserPassword = appUserPassword; }

    public Boolean getIsActive() { return isActive; }
	public void setIsActive(Boolean isActive) { this.isActive = isActive; }
	
    public List<AppRoleDao> getAppRoles() { return appRoles; }
    public void setAppRoles(List<AppRoleDao> appRoles) { this.appRoles = appRoles; }
    
    public List<UserActivationTokenDao> getUserActivationTokens(){ return userActivationTokens; }
    public void setUserActivationTokens(List<UserActivationTokenDao> userActivationTokens) { this.userActivationTokens = userActivationTokens;}
    
    public List<UserPasswordResetTokenDao> getUserPasswordResetTokens(){ return userPasswordResetTokens; }
    public void setUserPasswordResetTokens(List<UserPasswordResetTokenDao> userPasswordResetTokens) { this.userPasswordResetTokens = userPasswordResetTokens;}
    
    public List<ScenarioDao> getScenarios(){return scenarios;}
    public void setScenarios(List<ScenarioDao> scenarios) {this.scenarios = scenarios;}
}
