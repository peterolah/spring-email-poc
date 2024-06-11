package com.peterolah.example.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService {
    public static final String BODY = "árvíztűrő tükörfúrógép - ÁRVÍZTŰRŐ TÜKÖRFÚRÓGÉP";

    @Value("${email-config.from}")
    private String from;

    @Value("${email-config.to}")
    private String to;

    @Value("${email-config.subject}")
    private String subject;

    private final JavaMailSender javaMailSender;
    @Value("classpath:email-templates/mail-logo.png")
    private  Resource resourceFile;




    public void sendSimpleText() {

        final var message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("[text][" + UUID.randomUUID() + "] " +  subject);
            message.setText(BODY);

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendHtml () throws MessagingException, IOException {
        String htmlBody = new String(new ClassPathResource("/email-templates/template.html").getContentAsByteArray(), StandardCharsets.UTF_8 );
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("[html]" + subject);

        helper.setText(htmlBody, true);
        helper.addInline("attachment.png", resourceFile);
        javaMailSender.send(message);
    }


}
