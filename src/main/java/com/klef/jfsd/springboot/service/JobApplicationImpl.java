package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.JobApplication;
import com.klef.jfsd.springboot.repository.JobApplicationRepository;

@Service
public class JobApplicationImpl implements JobApplicationService
{

	@Autowired
	private JobApplicationRepository applicationRepository; 
	@Override
	public String insertapplication(JobApplication application) 
	{
		applicationRepository.save(application);
		return "Application Submitted Successfully!!";
	}
	@Override
	public JobApplication getapplication(int id) {
		return applicationRepository.findById(id).get();
	}
	@Override
	public List<JobApplication> viewall() {
		 return applicationRepository.findAll();
	}
	@Override
	public List<JobApplication> viewbyjobid(int job_id) {
		return applicationRepository.viewbyjobid(job_id);
	}

}
