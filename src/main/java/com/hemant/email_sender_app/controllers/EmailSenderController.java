package com.hemant.email_sender_app.controllers;


import com.hemant.email_sender_app.helper.CustomResponse;
import com.hemant.email_sender_app.services.EmailRequest;
import com.hemant.email_sender_app.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")

public class EmailSenderController {

    @Autowired
    private EmailService emailService;



    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){

        emailService.sendEmailWithHtml(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send SuccesFully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

//    @PostMapping("/send-with-file")
//    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestBody EmailRequest emailRequest , @RequestParam MultipartFile multipartFile) throws IOException {
//
//        emailService.sendEmailWithFile(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage() , multipartFile.getInputStream());
//        return ResponseEntity.ok(
//                CustomResponse.builder().message("Email Send SuccesFully").httpStatus(HttpStatus.OK).success(true).build()
//        );
//    }



                                // Json se nhi send hoga to form format me bhejenge image aur json ka text
    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestPart EmailRequest emailRequest , @RequestPart MultipartFile file) throws IOException {

        emailService.sendEmailWithFile(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage() , file.getInputStream());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send SuccesFully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }




}
