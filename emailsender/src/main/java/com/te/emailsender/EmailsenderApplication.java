package com.te.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.te.emailsender.service.MailSender;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmailsenderApplication {
	
	@Autowired
	private MailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(EmailsenderApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail() {
//		mailSender.sendEmail("shermivijay@gmail.com", "Lunch Time", "Shall we go to lunch");
//	}
	 
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		mailSender.sendEmail("shermivijay@gmail.com", "Evening", "Feeling sleepy", "C:\\Users\\Caroline\\Desktop\\mailsender\\mail.pdf");
	}

}
