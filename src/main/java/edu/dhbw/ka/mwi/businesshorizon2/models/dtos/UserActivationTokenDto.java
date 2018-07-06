package edu.dhbw.ka.mwi.businesshorizon2.models.dtos;

import java.time.LocalDateTime;

public class UserActivationTokenDto {
	private Long userActivationTokenId;
	private Long appUserId;
	private LocalDateTime expirationDate; 
	private String tokenKey;
	
	public UserActivationTokenDto(Long userActivationTokenId, Long appUserId, LocalDateTime expirationDate,
			String tokenKey) {
		super();
		this.userActivationTokenId = userActivationTokenId;
		this.appUserId = appUserId;
		this.expirationDate = expirationDate;
		this.tokenKey = tokenKey;
	}
	
	public UserActivationTokenDto() {}
	
	public Long getUserActivationTokenId() { return userActivationTokenId; }

	public void setUserActivationTokenId(Long userActivationTokenId) { this.userActivationTokenId = userActivationTokenId; }

	public Long getAppUserId() { return appUserId; }

	public void setAppUserId(Long appUserId) { this.appUserId = appUserId; }

	public LocalDateTime getExpirationDate() { return expirationDate; }

	public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

	public String getTokenKey() { return tokenKey; }

	public void setTokenKey(String tokenKey) { this.tokenKey = tokenKey; }

}
