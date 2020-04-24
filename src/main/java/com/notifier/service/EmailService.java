package com.notifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notifier.model.User;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(User user) throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("ucnotifier@gmail.com");
		mail.setSubject("Notifier Updated");
		mail.setText("One of your notifiers has been updated.");
		
		javaMailSender.send(mail);
	}
	
}
