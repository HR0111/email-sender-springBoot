package com.hemant.email_sender_app;


import com.hemant.email_sender_app.helper.Message;
import com.hemant.email_sender_app.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        System.out.println("Sending email..");
        emailService.sendEmail("komaldevidaschavan2004@gmail.com" , "email from spring boot" , "maru reptaa rappse ");
    }

    @Test
    void sendEmailWithFile(){

        emailService.sendEmailWithFile("hemantrathod0111@gmail.com" , "Email with file" , "Heyyy " , new File("src/main/resources/static/images/add.jpg"));
    }

    @Test
    void sendEmailWithFileWithStream(){

        File file =  new File("src/main/resources/static/images/add.jpg");

        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("hemantrathod0111@gmail.com" , "Email with file" , "Heyyy " ,is);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void getInbox(){
        List<Message> inboxMessage = emailService.getInboxMessages();
        inboxMessage.forEach(item->{
            System.out.println(item.getSubjects());
            System.out.println(item.getContent());
            System.out.println(item.getFiles());
            System.out.println("____________");
        });
    }
}
