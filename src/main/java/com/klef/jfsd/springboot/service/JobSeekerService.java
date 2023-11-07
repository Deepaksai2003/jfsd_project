package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.JobSeeker;

public interface JobSeekerService 
{
	public JobSeeker checkseekerlogin(String email,String pwd);
	
	public String addJobSeeker(JobSeeker jobSeeker);
	
	public String updatejobseeker(JobSeeker js);

	public String setActive(JobSeeker js);
	
	public JobSeeker getJs(String email);
	
	public List<JobSeeker> viewalljobseekers();
}
