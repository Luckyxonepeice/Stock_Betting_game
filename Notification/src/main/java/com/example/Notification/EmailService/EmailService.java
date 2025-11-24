package com.example.Notification.EmailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public ResponseEntity<String> sendEmail(String emailInfo){

        try{

            ObjectMapper mapper = new ObjectMapper();

            Map<String, String> email = mapper.readValue(emailInfo, Map.class);


            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setFrom("lakshaychauhan129@gmail.com");
            mail.setTo(email.get("email"));
            mail.setSubject(email.get("subject"));
            mail.setText(email.get("body"));

            javaMailSender.send(mail);

            return new ResponseEntity<>("Mail Send Completed",HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>("Failed Sending Email!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
