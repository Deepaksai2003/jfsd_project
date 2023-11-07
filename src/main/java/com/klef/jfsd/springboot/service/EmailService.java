package com.klef.jfsd.springboot.service;

public interface EmailService 
{
	public String sendEmail(String to);
	
	public String sendEmailAccepted(String to);
}
