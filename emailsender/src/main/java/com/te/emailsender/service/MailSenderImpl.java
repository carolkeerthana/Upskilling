package com.te.emailsender.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderImpl implements MailSender{
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String toEmail, String subject, String body, String attachment) throws MessagingException {
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("keerthana0497@gmail.com");
//		message.setTo(toEmail);
//		message.setText(body);
//		message.setSubject(subject);
//		
//		mailSender.send(message);
//		
//		System.out.println("Mail sent successfully...");
	
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("keerthana0497@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		mailSender.send(mimeMessage);
		
		System.out.println("Mail with attachment sent successfully...");
	}
	
	

}
