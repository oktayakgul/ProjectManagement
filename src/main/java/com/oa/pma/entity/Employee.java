package com.oa.pma.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	@ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
	fetch = FetchType.LAZY) //cascade -> all and remove not for now on dev. , fetchType.Lazy good for performance, Eager gets all the releated data to the memory
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;
	
	public Employee(String fname, String lname, String email) {
		this.fname = fname;
		this.email = email;
		this.lname = lname;
	}
	
	public Employee() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
