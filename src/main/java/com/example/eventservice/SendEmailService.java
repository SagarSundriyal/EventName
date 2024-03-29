package com.example.eventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

@Service
public class SendEmailService {

	@Autowired(required=true)
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		System.out.println(" msg  to---"+to);
		msg.setSubject(subject);
		System.out.println(" msg subjct---"+subject);
		msg.setText(text);
		System.out.println(" msg text---"+msg);
		javaMailSender.send(msg);
	}

	public void sendEmailWithAttachment(String to, String subject, String text, byte[] attachment,
			String attachmentName) {
		// TODO Auto-generated method stub
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
	MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	helper.setTo(to);
	helper.setSubject(subject);
	helper.setText(text);
    helper.addAttachment(attachmentName, new ByteArrayResource(attachment));
		javaMailSender.send(msg);
	}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}

}
