package com.peterolah.example.email.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.include=test")
class EmailServiceTestIT {


    @Autowired
    private EmailService emailService;

    @Test
    void sendSimpleText() {
        emailService.sendSimpleText();
    }

    @Test
    void sendHtml() {
        emailService.sendSimpleText();
    }
}