package com.klef.jfsd.springboot.service;


import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Recruiter;


public interface AdminService 
{

	public Admin checkAdminLogin(String uname,String pwd);
	
	public List<Recruiter> viewallrec();
	
	public String deleterec(String email);
	
	public String deletejobseeker(String email);

}
