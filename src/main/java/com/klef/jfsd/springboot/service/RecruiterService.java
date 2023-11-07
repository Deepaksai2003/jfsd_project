package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import com.klef.jfsd.springboot.model.Job;
import com.klef.jfsd.springboot.model.JobApplication;
import com.klef.jfsd.springboot.model.Recruiter;

import jakarta.transaction.Transactional;

public interface RecruiterService 
{
	public Recruiter checkrecruiterlogin(String email,String pwd);
	
	public String addRecruiter(Recruiter rec);
	
	@Modifying
	@Transactional
	public String updatereruiter(Recruiter r);
	
	public Recruiter getRecruiter(String email);
	
	public List<JobApplication> viewallresponses();

	
}
