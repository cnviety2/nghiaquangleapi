package com.services;

import com.dtos.EmailContentObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
@ComponentScan(basePackages = "com.config")
public class EmailServiceImpl {

    private JavaMailSenderImpl emailSender;

    public EmailServiceImpl(){
        emailSender = new JavaMailSenderImpl();
        emailSender.setHost("smtp.gmail.com");
        emailSender.setPort(587);
        emailSender.setUsername("cnviety9898@gmail.com");
        emailSender.setPassword("bulilin63047");

        Properties props = emailSender.getJavaMailProperties();
        props.put("mail.smtp.from","cnviety9898@gmail.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    public boolean sendEmail(EmailContentObject content) {
        Session session = Session.getInstance(emailSender.getJavaMailProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailSender.getUsername(), emailSender.getPassword());
                    }
                });
        try {
            content.setTo("lenghiadepgiai@gmail.com");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cnviety9898@gmail.com","Fan anh Nghỉa"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(content.getTo())
            );
            message.setSubject(content.getSubject());
            message.setText(content.getContent());
            this.emailSender.send(message);
        } catch (Exception e) {
            System.out.println("Email error:" + e.toString());
            return false;
        }
        return true;
    }
}
