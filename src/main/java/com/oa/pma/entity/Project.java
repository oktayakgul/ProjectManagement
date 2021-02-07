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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String stage; // notstared, inprogress, completed
	
	private String desc;
	
	@ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable (name = "project_employee", joinColumns = @JoinColumn (name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees;
	
	public Project(String name, String stage, String desc) {
		super();
		this.name = name;
		this.stage = stage;
		this.desc = desc;
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
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	//convenience method
	public void addEmployee(Employee employee){
		if(employees == null)
			employees = new ArrayList<>();
		employees.add(employee);
	}
	
}
