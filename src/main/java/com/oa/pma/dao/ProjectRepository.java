package com.oa.pma.dao;

import com.oa.pma.dto.StageStatus;
import com.oa.pma.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {
	
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage, count(*) count FROM PROJECT  group by stage")
	List<StageStatus> getStageStatus();
}
