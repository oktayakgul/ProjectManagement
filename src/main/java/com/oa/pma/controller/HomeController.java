package com.oa.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.dao.ProjectRepository;
import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.dto.StageStatus;
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
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping ("/")
	public String goHome(Model model) throws JsonProcessingException {
		List<Project> projectList = projectRepository.findAll();
		model.addAttribute("projects", projectList);
		
		List<EmployeeProjects> employeeProjects = employeeRepository.employeeProjects();
		model.addAttribute("employeeProjectsWithCount", employeeProjects);
		
		List<StageStatus> stageStatus = projectRepository.getStageStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String chartData = objectMapper.writeValueAsString(stageStatus);
		//["inprogress",1],["completed",2],["notstared",1]
		model.addAttribute("projectChartData", chartData);
		
		return "index";
	}
}
