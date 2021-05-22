package com.oa.pma.controller;

import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.entity.Employee;
import com.oa.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
	public String createEmployee(@Valid Employee employee, Errors errors){
		if(errors.hasErrors())
			return "employee/new";
		
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model){
		Employee employee = employeeService.findById(theId);
		model.addAttribute("employee", employee); // bind the employee to the form
		return "/employee/new";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId){
		Employee employee = employeeService.findById(theId);
		employeeService.delete(employee);
		return "redirect:/employee";
	}
	
	public List<EmployeeProjects> employeeProjects() {
		return employeeService.employeeProjects();
	}
}
