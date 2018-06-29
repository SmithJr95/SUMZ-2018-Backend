package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IEmailService;
import edu.dhbw.ka.mwi.businesshorizon2.config.EmailConfig;

@Service
public class EmailService implements IEmailService {
	
    @Autowired 
    EmailConfig emailConfig;
    
	@Autowired
	JavaMailSender mailSender;
	
	//@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    
	    mailSender.setHost(emailConfig.getHost());
	    mailSender.setPort(emailConfig.getPort());
	     
	    mailSender.setUsername(emailConfig.getUsername());
	    mailSender.setPassword(emailConfig.getPassword());
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", emailConfig.getSmtpAuth());
	    props.put("mail.smtp.starttls.enable", emailConfig.getStarttlsEnable());
	    props.put("mail.debug", "false");
	     
	    return mailSender;
	}
	
	public void sendEmail(String from, String to, String subject, String body) throws MessagingException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, false, "utf-8");
		msgHelper.setText(body, true);

		msgHelper.setFrom(from);
		msgHelper.setTo(to);
		msgHelper.setSubject(subject);
		msgHelper.setText(body);
		
		msg.setContent(body, "text/html");
		mailSender.send(msg);		
	}

}
