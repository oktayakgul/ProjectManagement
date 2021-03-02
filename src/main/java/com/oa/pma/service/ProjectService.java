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
	
	public void save(Project project) {
		repository.save(project);
	}
}
