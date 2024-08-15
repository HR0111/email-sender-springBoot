package com.hemant.email_sender_app.services;

import com.hemant.email_sender_app.helper.Message;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface EmailService {

    void sendEmail(String to , String subject, String message);
    void sendEmail(String []to , String subject, String message);
    void sendEmailWithHtml(String to , String subject, String htmlContent);
    void sendEmailWithFile(String to , String subject, String message, File file);
    void sendEmailWithFile(String to, String subject, String message, InputStream is);

    List<Message> getInboxMessages();
}
