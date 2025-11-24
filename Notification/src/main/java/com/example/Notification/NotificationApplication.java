package com.example.Notification;

import com.example.Notification.EmailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class NotificationApplication {


	public static void main(String[] args) {

		SpringApplication.run(NotificationApplication.class, args);
	}

}
