package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
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
        
        multipart.addBodyPart(messageBodyPart);
        
        DataSource ds = new URLDataSource(new URL("classpath:/email-templates/logo.png"));

        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(ds));
        messageBodyPart.setHeader("Content-ID", "<logo.png>");
        messageBodyPart.setFileName("logo.png");
        
        multipart.addBodyPart(messageBodyPart);

		msgHelper.setFrom(from);
		msgHelper.setTo(to);
		msgHelper.setSubject(subject);
		
		msg.setContent(multipart);
			
		mailSender.send(msg);		
	}

}
