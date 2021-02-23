package com.oa.pma.dao;

import com.oa.pma.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryIntegrationTest { //en yakin  application.properties dosyasini kullanir
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Test
	public void ifNewProjectSaved_thenSuccess(){
		Project project = new Project("Test 1","COMPLETE","Descripton for test");
		projectRepository.save(project);
		
		assertEquals(1, projectRepository.findAll().size());
		
	}
}
