package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService
{

	@Autowired 
    private JavaMailSender javaMailSender;
	
	 @Value("${spring.mail.username}") 
	    private String sender;
 
	@Override
	public String sendEmail(String to) 
	{
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(sender);
		sm.setSubject("login verification");
		sm.setTo(to);
		sm.setText("http://localhost:8000/emailverifypage?email="+to);
		javaMailSender.send(sm);
		return "Email Sent SuccessFully";
	}

	@Override
	public String sendEmailAccepted(String to) 
	{
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom(sender);
		sm.setSubject("Application  Accepted!!!!😊😊");
		sm.setTo(to);
		sm.setText("Dear Applicant,\r\n"
				+ "\r\n"
				+ "I hope this email finds you well. I am pleased to inform you that you have been selected for the [Job Role] at [Company Name]. Congratulations on your selection!\r\n"
				+ "\r\n"
				+ "Please find the attached offer letter and further details regarding your employment. We are excited to have you join our team and are confident that your skills and experience will make a valuable contribution to our organization.\r\n"
				+ "\r\n"
				+ "If you have any questions or need any additional information, please do not hesitate to reach out to our HR department at 8374451944.\r\n"
				+ "\r\n"
				+ "Once again, congratulations on your selection, and we look forward to welcoming you to the our team.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "\r\n"
				+ "[Your Name]\r\n"
				+ "[Your Title]\r\n"
				+ "[Company Name]\r\n"
				+ "");
		javaMailSender.send(sm);
		return "Email Sent SuccessFully";
	}

}
