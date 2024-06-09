package com.peterolah.example.email.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public static final String SUBJECT_AND_BODY = "árvíztűrő tükörfúrógép - ÁRVÍZTŰRŐ TÜKÖRFÚRÓGÉP";
    private final MailSender emailSender;

    public EmailService(MailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleText() {

        final var message = new SimpleMailMessage();
            message.setFrom("rehabit.munka@gmail.com");
            message.setTo("rehabit.munka@gmail.com");
            message.setSubject(SUBJECT_AND_BODY);
            message.setText(SUBJECT_AND_BODY);

        try {
            emailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }


}
