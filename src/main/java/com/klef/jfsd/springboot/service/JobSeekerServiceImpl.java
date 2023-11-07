package com.klef.jfsd.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.JobSeeker;
import com.klef.jfsd.springboot.repository.JobSeekerRepository;

@Service
public class JobSeekerServiceImpl implements JobSeekerService
{
	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Override
	public JobSeeker checkseekerlogin(String email, String pwd) {
		return jobSeekerRepository.checkseekerlogin(email, pwd);
	}

	@Override
	public String addJobSeeker(JobSeeker jobSeeker) 
	{
		jobSeekerRepository.save(jobSeeker);
		return "Added SuccessFully";
	}

	@Override
	public String updatejobseeker(JobSeeker js) {
	   JobSeeker j =  jobSeekerRepository.findById(js.getEmail()).get();
	   
	   j.setEmail(js.getEmail());
	   j.setFullname(js.getFullname());
	   j.setGender(js.getGender());
	   j.setPassword(js.getPassword());
	   
	   jobSeekerRepository.save(j);
	   
	   return "Updated Successfully!";
	    
	}

	@Override
	public String setActive(JobSeeker js) {
		JobSeeker obj= jobSeekerRepository.findById(js.getEmail()).get();
		obj.setActive(true);
		jobSeekerRepository.save(js);
		return "Changed Status";
	}

	@Override
	public JobSeeker getJs(String email) {
		return jobSeekerRepository.findById(email).get();
	}

	@Override
	public List<JobSeeker> viewalljobseekers() {
		return jobSeekerRepository.findAll();
	}
	
}
