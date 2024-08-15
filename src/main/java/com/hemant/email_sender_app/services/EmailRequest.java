package com.hemant.email_sender_app.services;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    private String to;
    private String subject;
    private String message;

}
