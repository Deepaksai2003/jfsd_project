package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>
{
	@Query("from JobApplication where job_id=?1")
	public List<JobApplication> viewbyjobid(int job_id);
}
