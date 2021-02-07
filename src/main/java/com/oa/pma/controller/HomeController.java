package com.oa.pma.controller;

import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dao.ProjectRepository;
import com.oa.pma.entity.Employee;
import com.oa.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	private ProjectRepository  projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String goHome(Model model){
		List<Project> projectList = projectRepository.findAll();
		List<Employee> employeeList = employeeRepository.findAll();
		model.addAttribute("projects",projectList);
		model.addAttribute("employees",employeeList);
		return "index";
	}
}
