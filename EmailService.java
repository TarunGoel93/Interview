package org.example;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    @Value("${email.smtp.username}")
    private String sender;

    @Value("${email.smtp.password}")
    private String password;


    public void sendMailWithAttachment(String body, String to, String subject) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        log.info("Sending email to the address " + to);
        helper.setFrom(sender);
        helper.setTo(to);
        helper.setSubject(subject);

        helper.setText(body, true);
        mailSender.send(message);
        log.info("Mail sent successfully !");
    }
}
