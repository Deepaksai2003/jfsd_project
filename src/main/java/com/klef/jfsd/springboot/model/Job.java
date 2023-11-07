package com.klef.jfsd.springboot.model;

import java.sql.Blob;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Job_table")
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String title;
    private String description;
    private double salary;
    private String location;
    private String company;
    private String rec_email;
    private Blob companyimage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRec_email() {
		return rec_email;
	}
	public void setRec_email(String rec_email) {
		this.rec_email = rec_email;
	}
	public Blob getCompanyimage() {
		return companyimage;
	}
	public void setCompanyimage(Blob companyimage) {
		this.companyimage = companyimage;
	} 
   
}
