package com.peterolah.example.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {
    public static final String SUBJECT_AND_BODY = "árvíztűrő tükörfúrógép - ÁRVÍZTŰRŐ TÜKÖRFÚRÓGÉP";
    public static final String FROM_AND_TO = "rehabit.munka@gmail.com";
    private final MailSender mailSender;

    private final JavaMailSender javaMailSender;

    @Value("classpath:email-templates/mail-logo.png")
    private Resource resourceFile;


    public EmailService(MailSender mailSender, JavaMailSender javaMailSender) {
        this.mailSender = mailSender;
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleText() {

        final var message = new SimpleMailMessage();
            message.setFrom(FROM_AND_TO);
            message.setTo(FROM_AND_TO);
            message.setSubject(SUBJECT_AND_BODY);
            message.setText(SUBJECT_AND_BODY);

        try {
            mailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendHtml () throws MessagingException, IOException {
        String htmlBody = new String(new ClassPathResource("/email-templates/template.html").getContentAsByteArray(), StandardCharsets.UTF_8 );
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(FROM_AND_TO);
        helper.setTo(FROM_AND_TO);
        helper.setSubject("[html]" + SUBJECT_AND_BODY);

        helper.setText(htmlBody, true);
        helper.addInline("attachment.png", resourceFile);
        javaMailSender.send(message);
    }


}
