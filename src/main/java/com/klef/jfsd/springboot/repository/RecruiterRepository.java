package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.JobApplication;
import com.klef.jfsd.springboot.model.Recruiter;

@Repository
public interface RecruiterRepository  extends JpaRepository<Recruiter, String>
{
    @Query("select r from Recruiter r where r.email=?1 and r.password=?2")
	public Recruiter checkrecruiterlogin(String email,String pwd);
	
    @Query("select jm from JobMapping jm where jm.job.id=jm.application.job_id")
	public List<JobApplication> viewallresponses();

}
