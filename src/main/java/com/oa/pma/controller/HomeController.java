package com.oa.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dao.ProjectRepository;
import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.dto.StageStatus;
import com.oa.pma.entity.Employee;
import com.oa.pma.entity.Project;
import com.oa.pma.sample.Car;
import com.oa.pma.service.EmployeeService;
import com.oa.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	
	@Value("${version}") //dataFromEnvVar intellij .bash_profile 'i env var olarak goremedi, duzelt.
	private String appVersion;
	
	@Autowired
	Car car;
	
	@Autowired
	ProjectController projectController;
	
	@Autowired
	EmployeeController employeeController;
	
	@GetMapping ("/")
	public String goHome(Model model) throws JsonProcessingException {
		model.addAttribute("appVersion", appVersion);
		
		List<Project> projectList = projectController.findAll();
		model.addAttribute("projects", projectList);
		
		List<EmployeeProjects> employeeProjects = employeeController.employeeProjects();
		model.addAttribute("employeeProjectsWithCount", employeeProjects);
		
		List<StageStatus> stageStatus = projectController.getStageStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String chartData = objectMapper.writeValueAsString(stageStatus);
		//["inprogress",1],["completed",2],["notstared",1]
		model.addAttribute("projectChartData", chartData);
		
		return "index";
	}
}
