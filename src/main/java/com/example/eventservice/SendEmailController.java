package com.example.eventservice;

/*
import java.io.IOException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventservice.BookingRequest;
import com.example.eventservice.Event;
import com.example.eventservice.EventserviceApplication;
@RestController
public class SendEmailController {
	
	@Autowired
	EventserviceApplication sendingEmailApplication;

	@Autowired
	SendEmailService sendEmailService;
	
	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
		sendingEmailApplication.sendEmail();//eventName,  numSeats,  userName);
		//sendingEmailApplication.sendEmailWithAttachment();
	   return "Email sent successfully";   
	}
	
	/*@PostMapping("/bookSeats")
	public ResponseEntity<String> bookSeats(@RequestBody BookingRequest bookingRequest){
		
		byte[] pdfContent = generatePdfContent(bookingRequest);
		
			String toEmail = bookingRequest.getMailId();//"sagar100196@gmail.com";
			String subject = "Booking confirm";
			String body = String.format(" Thanks for booking,\n Seats: "+bookingRequest.getNumSeats()
			+" and eventname is :" +bookingRequest.getEventName());
	
			//sendEmailService.sendEmail(toEmail, subject, body);
			sendEmailService.sendEmailWithAttachment(toEmail, subject, body, pdfContent, "booking_confirmation.pdf");
			return ResponseEntity.status(HttpStatus.OK).body("Seats booked successfully ");
	}

	private byte[] generatePdfContent(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		String pdfContent = "Booking details:\n\nEvent name: "+bookingRequest.getEventName()
		+ "\nNumber of seats: "+bookingRequest.getNumSeats();
		return pdfContent.getBytes();
	}
}*/