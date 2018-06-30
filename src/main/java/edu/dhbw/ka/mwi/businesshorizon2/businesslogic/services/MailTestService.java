package edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.interfaces.EmailService;

@Component
public class MailTestService implements EmailService {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(
      String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        message.setFrom("sumz1718@gmx.de");
        emailSender.send(message);
        System.out.println("Message sent.");
    }
}