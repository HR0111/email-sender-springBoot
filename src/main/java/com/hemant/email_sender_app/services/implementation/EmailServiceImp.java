package com.hemant.email_sender_app.services.implementation;

import com.hemant.email_sender_app.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
//@RequiredArgsConstructor
public class EmailServiceImp implements EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailServiceImp.class);

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("hemantrathod0112@gmail.com");
        javaMailSender.send(simpleMailMessage);
        logger.info("Email has been sent....");
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("hemantrathod0112@gmail.com");
        javaMailSender.send(simpleMailMessage);
        logger.info("Email has been sent from multiUser....");

    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {


//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        MimeMessage simpleMailMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage , true , "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);
            helper.setFrom("hemantrathod0112@gmail.com");
            javaMailSender.send(simpleMailMessage);

            logger.info("sent email html content");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true);

            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setFrom("hemantrathod0112@gmail.com");
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), file);
            javaMailSender.send(mimeMessage);


            logger.info("sent email FIleee content");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, InputStream is) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true);

            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setFrom("hemantrathod0112@gmail.com");

            File file = new File("src/main/resources/email/test.png");
            Files.copy(is,file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            FileSystemResource fileSystemResource = new FileSystemResource(file);

            mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), file);
            javaMailSender.send(mimeMessage);


            logger.info("sent email FIleee content including inpustream");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
