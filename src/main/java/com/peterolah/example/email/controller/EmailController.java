package com.peterolah.example.email.controller;

import com.peterolah.example.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @RequestMapping(value = "send-simple-text", method = RequestMethod.GET)
    public void sendSimpleText() {
        emailService.sendSimpleText();
    }

    @RequestMapping(value = "send-html", method = RequestMethod.GET)
    public void sendHtml() {
        try {
            emailService.sendHtml();
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
