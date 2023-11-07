package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.JobSeeker;
@Repository
public interface JobSeekerRepository  extends JpaRepository<JobSeeker, String>
{
    @Query("select js from JobSeeker js where js.email=?1 and js.password=?2")
	public JobSeeker checkseekerlogin(String email,String pwd);
   
}
