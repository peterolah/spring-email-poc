package com.peterolah.example.email.controller;

import com.peterolah.example.email.service.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
