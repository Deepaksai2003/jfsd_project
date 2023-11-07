package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Job;
import com.klef.jfsd.springboot.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService
{
	@Autowired
	private JobRepository jobRepository;

	@Override
	public String insertjob(Job job) {
		 jobRepository.save(job);
		return "Job Added Successfully!!";
	}

	@Override
	public List<Job> viewalljobs() {
		return jobRepository.findAll();
	}

	@Override
	public Job getjob(int id) {
		return jobRepository.findById(id).get();
	}

	@Override
	public Job getjobemail(String email) {
		return jobRepository.viewjob(email);
	}

	@Override
	public String deletejob(int id) {
		jobRepository.deleteById(id);
		return "Job Deleted Successfully!";
	}
   
	
	
}
