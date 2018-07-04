package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userPasswordResetToken")
public class UserPasswordResetTokenDao {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
		
		@Column(name = "userId")
		private Long userId;
		
		@Column(name = "expirationDate")
		private LocalDateTime expirationDate; 
		
		@Column(name = "key")
		private String key;
		
		public UserPasswordResetTokenDao(Long userId, LocalDateTime expirationDate, String key){
			this.userId = userId;
			this.expirationDate = expirationDate; 
			this.key = key;
		}
		
		public UserPasswordResetTokenDao() {
			
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public LocalDateTime getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(LocalDateTime expirationDate) {
			this.expirationDate = expirationDate;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
		
		public Boolean equals(UserPasswordResetTokenDao userPasswordResetToken) {
			Boolean idEquals 				= userPasswordResetToken.id == this.id;
			Boolean userIdEquals 			= userPasswordResetToken.userId == this.userId;
			Boolean expirationDateEquals 	= userPasswordResetToken.expirationDate.equals(this.expirationDate);
			Boolean keyEquals				= userPasswordResetToken.key.equals(this.key);
			
			return idEquals && userIdEquals && expirationDateEquals && keyEquals;
		}
}
