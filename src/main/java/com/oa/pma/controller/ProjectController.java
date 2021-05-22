package com.oa.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dao.ProjectRepository;
import com.oa.pma.dto.ProjectDates;
import com.oa.pma.dto.StageStatus;
import com.oa.pma.entity.Employee;
import com.oa.pma.entity.Project;
import com.oa.pma.service.EmployeeService;
import com.oa.pma.service.ProjectService;
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
@RequestMapping ("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String getProjects(Model model) {
		List<Project> projects = projectService.findAll();
		model.addAttribute("projects", projects);
		return "/project/list";
	}
	
	@GetMapping ("/new")
	public String displayForm(Model model) {
		Project aProject = new Project();
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees",employeeList);
		return "/project/new";
	}
	
	@PostMapping ("/save")
	public String createProject(@Valid Project project, Model model, Errors errors) {
		if(errors.hasErrors())
			return "project/new";
		
		projectService.save(project);
		/*Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
		for (Employee chosenEmployee : chosenEmployees) {
			chosenEmployee.setProject(project);
			employeeRepository.save(chosenEmployee);
		} // no need on manyToMany relationship */
		//use a redirect to prevent duplicate submissions
		return "redirect:/project";
	}
	
	@GetMapping("/update")
	public String displayProjectUpdateForm(@RequestParam("id") long theId, Model model){
		Project project = projectService.findById(theId);
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("project", project);
		model.addAttribute("allEmployees", employeeList);
		return "/project/new";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") long theId){
		projectService.deleteById(theId);
		return "redirect:/project";
	}
	
	public List<Project> findAll() {
		return projectService.findAll();
	}
	
	public List<StageStatus> getStageStatus() {
		return projectService.getStageStatus();
	}
	
	
	@GetMapping("/timeline")
	public String displayProjectTimeLines(Model model){
		List<ProjectDates> projectDatesList = projectService.getProjectDates();
		String listJSON = null;
		try {
			listJSON = new ObjectMapper().writeValueAsString(projectDatesList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------timeline data----------------");
		System.out.println(listJSON);
		model.addAttribute("projectDatesList", listJSON);
		return "/project/timeline";
	}
}
