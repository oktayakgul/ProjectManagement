package com.oa.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
	
	@Id
	@SequenceGenerator (name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "project_seq")
	private long id;
	
	@NotBlank
	@Size (min=2, max= 50)
	private String name;
	
	@NotBlank
	private String stage; // notstared, inprogress, completed
	
	@NotBlank
	@Size (min=2, max= 500)
	private String description;
	
	@ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable (name = "project_employee", joinColumns = @JoinColumn (name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	@JsonIgnore
	private List<Employee> employees;
	
	
	private Date startDate;
	
	private Date endDate;
	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	public Project() {
	}
	
	public Project(List<Employee> employees) {
		this.employees = employees;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStage() {
		return stage;
	}
	
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	//convenience method
	public void addEmployee(Employee employee){
		if(employees == null)
			employees = new ArrayList<>();
		employees.add(employee);
	}
	
}
