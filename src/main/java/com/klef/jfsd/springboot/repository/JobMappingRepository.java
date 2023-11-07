package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.JobMapping;

@Repository
public interface JobMappingRepository extends JpaRepository<JobMapping, Integer>
{
  
}
