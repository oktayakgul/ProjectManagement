package com.oa.pma.dao;

import com.oa.pma.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {
	
	@Override
	List<Project> findAll();
}
