package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.time.LocalDateTime;

public class UserPasswordResetTokenDto {
	private Long userPasswordResetTokenId;
	private Long appUserId;
	private LocalDateTime expirationDate; 
	private String tokenKey;
	
	public UserPasswordResetTokenDto(Long userActivationTokenId, Long appUserId, LocalDateTime expirationDate,
			String tokenKey) {
		super();
		this.userPasswordResetTokenId = userActivationTokenId;
		this.appUserId = appUserId;
		this.expirationDate = expirationDate;
		this.tokenKey = tokenKey;
	}
	
	public Long getUserActivationTokenId() { return userPasswordResetTokenId; }

	public void setUserActivationTokenId(Long userActivationTokenId) { this.userPasswordResetTokenId = userActivationTokenId; }

	public Long getAppUserId() { return appUserId; }

	public void setAppUserId(Long appUserId) { this.appUserId = appUserId; }

	public LocalDateTime getExpirationDate() { return expirationDate; }

	public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

	public String getTokenKey() { return tokenKey; }

	public void setTokenKey(String tokenKey) { this.tokenKey = tokenKey; }
}
