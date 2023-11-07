package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.*;

@Repository
public interface CaptchaRepository extends JpaRepository<CaptchaEntity, Long> {
                                                       // entity class and data type of primary key
  
  
  

}