package com.oa.pma.controller;

import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.entity.Employee;
import com.oa.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String getEmployees(Model model){
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees",employees);
		return "/employee/list";
	}
	
	@GetMapping ("/new")
	public String displayEmployeeFromModel(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "/employee/new";
	}
	
	@PostMapping ("/save")
	public String createEmployee(Employee employee){
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	
	public List<EmployeeProjects> employeeProjects() {
		return employeeService.employeeProjects();
	}
}
