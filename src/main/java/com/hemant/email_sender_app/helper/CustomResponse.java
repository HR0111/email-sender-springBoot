package com.hemant.email_sender_app.helper;


import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomResponse {

        private String message;
        private HttpStatus httpStatus;
        private boolean success = false;


}
