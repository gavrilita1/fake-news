package com.example.fakenews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
    public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.from.address}")
    private String fromAddress;

    @Value("${email.receiver}")
    private String toEmail;

    @Value("${email.message}")
    private String message;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.file}")
    private File file;


    private void sendMailMultipart(File file) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(fromAddress);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(message);

        if (file != null) {
            helper.addAttachment(file.getName(), file);
        }
        javaMailSender.send(mimeMessage);
    }

    public void sendMail() {
        try {
            sendMailMultipart(null);
        } catch (Exception e) {
            throw new RuntimeException("bla", e);
        }
    }

    public void sendMailfile() {
        try {
            sendMailMultipart(file);
        } catch (Exception e) {
            throw new RuntimeException("bla file", e);
        }
    }
}
