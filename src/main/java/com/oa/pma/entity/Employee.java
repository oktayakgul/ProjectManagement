package com.oa.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oa.pma.validatiton.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
	
	@Id
	@SequenceGenerator (name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "employee_seq") //sequence faster than identity (hibernate batch updates)
	private long id;
	
	@NotNull
	@Size (min=2, max= 50)
	private String fname;
	
	@NotNull
	private String lname;
	
	
	@Email
	@Column( nullable = false) // unique = true,
	@UniqueValue
	private String email;
	
	@ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
	fetch = FetchType.LAZY) //cascade -> all and remove not for now on dev. , fetchType.Lazy good for performance, Eager gets all the releated data to the memory
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	@JsonIgnore // when pull an employee try to pull projects because of many to many relationship
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
