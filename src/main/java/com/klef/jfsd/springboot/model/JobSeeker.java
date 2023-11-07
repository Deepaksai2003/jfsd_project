package com.klef.jfsd.springboot.model;

import java.sql.Blob;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobseeker_table")
public class JobSeeker
{
	@Id
	private String email;
	private int job_id;
    private String fullname;
    private String password;
    private String gender;
    private boolean active;
    private Blob productimage;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Blob getProductimage() {
		return productimage;
	}
	public void setProductimage(Blob productimage) {
		this.productimage = productimage;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	} 	 
}
