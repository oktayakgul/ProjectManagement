package com.oa.pma.service;

import com.oa.pma.dao.ProjectRepository;
import com.oa.pma.dto.StageStatus;
import com.oa.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository repository;
	
	public List<Project> findAll() {
		return repository.findAll();
	}
	
	public List<StageStatus> getStageStatus() {
		return repository.getStageStatus();
	}
	
	public Project save(Project project) {
		return repository.save(project);
	}
	
	public Project findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
