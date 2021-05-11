package com.controllers;

import com.dtos.EmailContentObject;
import com.services.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "email")
public class EmailController {

    @PostMapping("/send")
    public Object test(@RequestBody EmailContentObject emailContent) {
        EmailServiceImpl emailService = new EmailServiceImpl();
        boolean flag = emailService.sendEmail(emailContent);
        if (flag) {
            return new ResponseEntity<Object>("ok", HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("Not ok", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
