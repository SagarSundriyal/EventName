package com.example.eventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
//@ComponentScan(basePackages = {"com.example.eventservice"})
public class EventserviceApplication {

	@Autowired//(required=true)
    private JavaMailSender javaMailSender;
	
	 @Bean
	   public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(EventserviceApplication.class, args);
	}
}	
	/*public void sendEmail()
	{
        SimpleMailMessage msg = new SimpleMailMessage();
 
        msg.setTo("sagar100196@gmail.com");
        msg.setSubject(" Event name is ");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
    }

	
	public void sendEmailWithAttachment() throws MessagingException, IOException 
	{
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("sagar100196@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Check attachment for image!</h1>", true);

    FileSystemResource file = new FileSystemResource(new File
    		("C://Users//Sagar Sundriyal//Downloads/2023-India-All.csv"));

        helper.addAttachment("2023-India-All.csv", file);

        javaMailSender.send(msg);

    }}	*/
