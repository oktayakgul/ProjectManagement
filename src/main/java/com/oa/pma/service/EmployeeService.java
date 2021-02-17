package com.oa.pma.service;

import com.oa.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	// Field Injection
	@Autowired
	private EmployeeRepository repository;

	//Construction Injection  // this works because of @Service annotation
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
	
}
