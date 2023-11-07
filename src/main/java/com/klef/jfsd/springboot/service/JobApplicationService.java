package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.JobApplication;

public interface JobApplicationService
{
  public String insertapplication(JobApplication application);
  public JobApplication getapplication(int id);
  public List<JobApplication> viewall();
  public List<JobApplication> viewbyjobid(int job_id);
}
