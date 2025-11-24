package com.example.Notification.Config;

import com.example.Notification.EmailService.EmailService;
import com.example.Notification.NotificationApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConfigListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaConfigListener.class);

    @Autowired
    EmailService emailService;

    @KafkaListener(topics="email",groupId = "email-group")
    public void kafkaConsumer(String message){
        emailService.sendEmail(message);
    }
}
