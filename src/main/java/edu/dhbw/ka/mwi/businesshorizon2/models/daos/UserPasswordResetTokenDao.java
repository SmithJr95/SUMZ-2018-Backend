package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.time.LocalDateTime;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserPasswordResetToken")
@Table(name = "UserPasswordResetToken")
public class UserPasswordResetTokenDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserPasswordResetTokenId")
    private Long userPasswordResetTokenId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AppUserId")
	private AppUserDao appUser;
	
	@Column(name = "ExpirationDate")
	private LocalDateTime expirationDate; 
	
	@Column(name = "TokenKey", columnDefinition = "nvarchar")
	private String tokenKey;
	
	public UserPasswordResetTokenDao() {}
	
	public UserPasswordResetTokenDao(Long userPasswordResetTokenId, AppUserDao appUser, LocalDateTime expirationDate, String tokenKey) {
		this.userPasswordResetTokenId = userPasswordResetTokenId;
		this.appUser = appUser;
		this.expirationDate = expirationDate;
		this.tokenKey = tokenKey;
	}
	
	public UserPasswordResetTokenDao(LocalDateTime expirationDate, String tokenKey) {
		this.expirationDate = expirationDate; 
		this.tokenKey = tokenKey;
	}
	
	public Long getUserPasswordResetTokenId() { return userPasswordResetTokenId; }

	public LocalDateTime getExpirationDate() { return expirationDate; }
	public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

	public String getTokenKey() { return tokenKey; }
	public void setKey(String tokenKey) { this.tokenKey = tokenKey; }
	
	public AppUserDao getAppUser() { return appUser; }
	public void setAppUser(AppUserDao appUser) { this.appUser = appUser; }
	
	public Boolean equals(UserPasswordResetTokenDao userPasswordResetToken) {
		Boolean idEquals = userPasswordResetToken.userPasswordResetTokenId.equals(this.userPasswordResetTokenId);
		Boolean userIdEquals = userPasswordResetToken.appUser.getAppUserId().equals(this.appUser.getAppUserId());
		Boolean expirationDateEquals = userPasswordResetToken.expirationDate.equals(this.expirationDate);
		Boolean keyEquals = userPasswordResetToken.tokenKey.equals(this.tokenKey);
		
		return idEquals && userIdEquals && expirationDateEquals && keyEquals;
	}
	
	public String toString() {
		String result = ""; 
		result += " userPasswordResetTokenId: " + userPasswordResetTokenId; 
		result += " appUserId:_" + appUser.getAppUserId();
		result += " expirationDate: " + expirationDate;
		result += " tokenKey: " + tokenKey;
		
		return result; 
	}
}
