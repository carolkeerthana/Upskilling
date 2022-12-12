package com.te.emailsender.service;

import jakarta.mail.MessagingException;

public interface MailSender {
	
	void sendEmail(String toEmail, String subject, String body, String attachment) throws MessagingException;

}
