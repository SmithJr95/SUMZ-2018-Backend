package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserActivationToken")
@Table(name = "UserActivationToken")
public class UserActivationTokenDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserActivationTokenId")
    private Long userActivationTokenId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AppUserId")
	private AppUserDao appUser;
	
	@Column(name = "ExpirationDate")
	private LocalDateTime expirationDate; 
	
	@Column(name = "TokenKey", columnDefinition = "nvarchar")
	private String tokenKey;
	
	public UserActivationTokenDao() {}
	
	public UserActivationTokenDao(Long userActivationTokenId, AppUserDao appUser, LocalDateTime expirationDate, String tokenKey) {
		this.userActivationTokenId = userActivationTokenId;
		this.appUser = appUser;
		this.expirationDate = expirationDate;
		this.tokenKey = tokenKey;
	}
	
	public UserActivationTokenDao(LocalDateTime expirationDate, String tokenKey) {
		this.expirationDate = expirationDate;
		this.tokenKey = tokenKey;
	}
		
	public Long getUserActivationTokenId() { return userActivationTokenId; }

	public LocalDateTime getExpirationDate() { return expirationDate; }
	public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

	public String getTokenKey() { return tokenKey; }
	public void setKey(String tokenKey) { this.tokenKey = tokenKey; }
	
	public AppUserDao getAppUser() { return appUser; }
	public void setAppUser(AppUserDao appUser) { this.appUser = appUser; }
	
	public Boolean equals(UserActivationTokenDao userActivationToken) {
		Boolean idEquals = userActivationToken.userActivationTokenId.equals(this.userActivationTokenId);
		Boolean userIdEquals = userActivationToken.appUser.getAppUserId().equals(this.appUser.getAppUserId());
		Boolean expirationDateEquals = userActivationToken.expirationDate.equals(this.expirationDate);
		Boolean keyEquals = userActivationToken.tokenKey.equals(this.tokenKey);
		
		return idEquals && userIdEquals && expirationDateEquals && keyEquals;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += ("userActivationTokenId: " + userActivationTokenId);
		result += (" appUserId: " + appUser.getAppUserId());
		result += (" expirationDate: " + expirationDate);
		result += (" tokenKey: " + tokenKey);
		
		return result; 
	}
}
