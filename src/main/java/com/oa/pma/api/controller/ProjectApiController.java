package com.oa.pma.api.controller;

import com.oa.pma.entity.Project;
import com.oa.pma.service.ProjectService;
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
@RequestMapping("/api/project")
public class ProjectApiController {
	
	@Autowired
	ProjectService service;
	
	@GetMapping
	public List<Project> getProjects(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@RequestBody @Valid Project project){
		return service.save(project);
	}
	
	@PutMapping(consumes = "application/json") // actually consumes = "application/json" comes by default no need for json
	@ResponseStatus(HttpStatus.OK)
	public Project update(@RequestBody @Valid Project project){
		return service.save(project);
	}
	
	@PatchMapping(path = "/{id}", consumes = "application/json") // cascading method
	public Project partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Project patchProject){
		Project project = service.findById(id);
		
		if(patchProject.getName() != null)
			project.setName(patchProject.getName());
		if(patchProject.getStage() != null)
			project.setStage(patchProject.getStage());
		if(patchProject.getDescription() != null)
			project.setDescription(patchProject.getDescription());
		
		return service.save(project);
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
