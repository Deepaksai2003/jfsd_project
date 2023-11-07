package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruiter_table")
public class Recruiter 
{
	@Id
	private String email;
    private String fullname;
    private String password;
    private String gender;
    private boolean isactive;
    private Blob recruiterimage;
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
	public Blob getRecruiterimage() {
		return recruiterimage;
	}
	public void setRecruiterimage(Blob recruiterimage) {
		this.recruiterimage = recruiterimage;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
}
