package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Recruiter;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.JobSeekerRepository;
import com.klef.jfsd.springboot.repository.RecruiterRepository;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
	private AdminRepository adminRepository;
    
    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    
	@Override
	public Admin checkAdminLogin(String uname, String pwd) {
	 	return adminRepository.checkAdminLogin(uname, pwd);
	}
	
	@Override
	public List<Recruiter> viewallrec() {
		return recruiterRepository.findAll();
	}
	
	public String deleterec(String email)
	{
		recruiterRepository.deleteById(email);
		return "Deleted SuccessFully";
	}

	@Override
	public String deletejobseeker(String email) {
		jobSeekerRepository.deleteById(email);
		return "Deleted Sucessfully!";
	}
	

}
