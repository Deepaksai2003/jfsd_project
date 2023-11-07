package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>
{
  @Query("select j from Job j where j.rec_email=?1")	
  public Job viewjob(String email);
}
