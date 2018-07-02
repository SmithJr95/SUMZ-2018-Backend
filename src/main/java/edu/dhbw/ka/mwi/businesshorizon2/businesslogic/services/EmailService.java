package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.IEmailService;
import edu.dhbw.ka.mwi.businesshorizon2.config.EmailConfig;

@Service
public class EmailService implements IEmailService {
	
    @Autowired 
    EmailConfig emailConfig;
    
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired 
	SpringTemplateEngine templateEngine;
	
	@Bean
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
	
	public void sendEmail(String from, String to, String subject, String template, Map<String, Object> vars) throws MessagingException, IOException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());       

		Context context = new Context();
        context.setVariables(vars);
        
        String html = templateEngine.process(template, context);
        
        Multipart multipart = new MimeMultipart();
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(html, "text/html");
        
        Resource resource = new ClassPathResource("/email-templates/logo.png");
        
        MimeBodyPart attachPart = new MimeBodyPart();
        
        attachPart.attachFile(resource.getFile());
        
        multipart.addBodyPart(attachPart);
        multipart.addBodyPart(messageBodyPart);

		msgHelper.setFrom(from);
		msgHelper.setTo(to);
		msgHelper.setSubject(subject);
		
		msg.setContent(multipart);
			
		mailSender.send(msg);		
	}

}
