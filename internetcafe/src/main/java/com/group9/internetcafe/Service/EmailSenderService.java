package com.group9.internetcafe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("jcarlsabejon@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject("InternetCafe Online Reservation");
		
		mailSender.send(message);
		
		System.out.println("Mail Sent Successfully ^^");
	}
}
