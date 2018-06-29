package edu.dhbw.ka.mwi.businesshorizon2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {
    @Value
    ("${spring.mail.host}")
    String host;
    
    @Value
    ("${spring.mail.port}")
    Integer port;
    
    @Value
    ("${spring.mail.username}")
    String username;
    
    @Value
    ("${spring.mail.password}")
    String password;    
    
    @Value
    ("${spring.mail.properties.mail.smtp.auth}")
    Boolean smtpAuth;
    
    @Value
    ("${spring.mail.properties.mail.smtp.starttls.enable}")
    Boolean starttlsEnable; 
    
    @Value 
    ("${spring.mail.properties.mail.smtp.starttls.required}")
    Boolean starttlsRequired;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(Boolean smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public Boolean getStarttlsEnable() {
		return starttlsEnable;
	}

	public void setStarttlsEnable(Boolean starttlsEnable) {
		this.starttlsEnable = starttlsEnable;
	}

	public Boolean getStarttlsRequired() {
		return starttlsRequired;
	}

	public void setStarttlsRequired(Boolean starttlsRequired) {
		this.starttlsRequired = starttlsRequired;
	} 
}
