package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Job;

public interface JobService 
{
   public String insertjob(Job job);
   
   public List<Job> viewalljobs();
   
   public Job getjob(int id);
   
   public Job getjobemail(String email);
   
   public String deletejob(int id);
}
