package com.klef.jfsd.springboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobmapping_table")
public class JobMapping 
{
	@Id
	private int id;
	
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "job_id")
  private Job job;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "jobapplication_id")
  private JobApplication application;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "recruiter_id")
  private Recruiter recruiter;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Job getJob() {
	return job;
}

public void setJob(Job job) {
	this.job = job;
}

public JobApplication getApplication() {
	return application;
}

public void setApplication(JobApplication application) {
	this.application = application;
}

public Recruiter getRecruiter() {
	return recruiter;
}

public void setRecruiter(Recruiter recruiter){
	this.recruiter = recruiter;
}
  
}
