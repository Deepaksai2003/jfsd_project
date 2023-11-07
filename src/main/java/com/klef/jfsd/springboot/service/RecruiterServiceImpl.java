package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Job;
import com.klef.jfsd.springboot.model.JobApplication;
import com.klef.jfsd.springboot.model.JobSeeker;
import com.klef.jfsd.springboot.model.Recruiter;
import com.klef.jfsd.springboot.repository.RecruiterRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService
{
	@Autowired
	private RecruiterRepository recruiterRepository;

	@Override
	public Recruiter checkrecruiterlogin(String email, String pwd) {
		return recruiterRepository.checkrecruiterlogin(email, pwd);
	}

	@Override
	public String addRecruiter(Recruiter rec) {
		recruiterRepository.save(rec);
		return "Recruiter Added Successfully!";
	}

	@Override
	public String updatereruiter(Recruiter r)
	{
		Recruiter  reg =  recruiterRepository.findById(r.getEmail()).get();
		   
		   reg.setEmail(r.getEmail());
		   reg.setFullname(r.getFullname());
		   reg.setGender(r.getGender());
		   reg.setPassword(r.getPassword());
		   
		   recruiterRepository.save(reg);
		   
		   return "Updated Successfully!";
	}

	@Override
	public Recruiter getRecruiter(String email) 
	{
        return recruiterRepository.findById(email).get();
	}

	@Override
	public List<JobApplication> viewallresponses() {
		return recruiterRepository.viewallresponses();
	}


}
