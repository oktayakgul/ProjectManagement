package com.oa.pma.api.controller;

import com.oa.pma.entity.Employee;
import com.oa.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Valid Employee employee){
		return service.save(employee);
	}
	
	@PutMapping(consumes = "application/json") // actually consumes = "application/json" comes by default no need for json
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody @Valid Employee employee){
		return service.save(employee);
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json") // cascading method
	public Employee partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Employee patchEmployee){
		Employee employee = service.findById(id);
		
		if(patchEmployee.getEmail() != null)
			employee.setEmail(patchEmployee.getEmail());
		if(patchEmployee.getFname() != null)
			employee.setFname(patchEmployee.getFname());
		if(patchEmployee.getLname() != null)
			employee.setLname(patchEmployee.getLname());
		
		return service.save(employee);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id){
		try {
			service.deleteById(id);
		}catch (EmptyResultDataAccessException e){
		
		}
	}
}
