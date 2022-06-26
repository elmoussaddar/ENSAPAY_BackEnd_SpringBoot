package com.example.ensapay.service;


import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    protected void sendEmail(String recipient, String content) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("in authentication");
                return new PasswordAuthentication("ensapay.services@gmail.com", "tyfxuctfeczaqgrw");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("ensapay.services@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        msg.setSubject("EnsaPay Application Services");
        msg.setContent(content, "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);

    }


}

