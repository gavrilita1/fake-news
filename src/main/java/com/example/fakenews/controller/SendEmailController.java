package com.example.fakenews.controller;

import com.example.fakenews.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.File;

@RestController
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/testSendEmail")
    public void sendEmail() {
        try {
            emailService.sendMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/testSendEmailFile")
    public void sendEmailFile() {
        try {
            emailService.sendMailfile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
