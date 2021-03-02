package com.oa.pma.service;

import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public void save(Employee employee) {
		repository.save(employee);
	}
	
	public List<EmployeeProjects> employeeProjects() {
		return repository.employeeProjects();
	}
	
/*
	private IStaffRepository repository;
	//public EmployeeService(IStaffRepository repository) { // and add @Primary annotation to StaffRepositoryImpl1 class
	public EmployeeService(@Qualifier ("staffRepositoryImpl1") IStaffRepository repository) {
		this.repository = repository;
	}
	
	//Field Injection
	@Qualifier ("staffRepositoryImpl2")
	@Autowired
	IStaffRepository repository2;
	
	
	//Construction Injection  // this works because of @Service annotation (stereotype)
	private EmployeeRepository repository2;
	public EmployeeService(EmployeeRepository repository2) {
		this.repository2 = repository2;
	}
	
	//Setter Injection
	private EmployeeRepository repository3;
	@Autowired
	public void setRepository3(EmployeeRepository repository3) {
		this.repository3 = repository3;
	}
*/
	
}
