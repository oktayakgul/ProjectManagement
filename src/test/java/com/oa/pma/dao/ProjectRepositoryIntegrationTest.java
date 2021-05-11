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
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql","classpath:data.sql"}),
		@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")} /* actually, no really need drop.sql */)
public class ProjectRepositoryIntegrationTest { //en yakin  application.properties dosyasini kullanir
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Test
	public void ifNewProjectSaved_thenSuccess(){
		Project project = new Project("Test 1","COMPLETE","Descripton for test");
		projectRepository.save(project);
		
		assertEquals(5, projectRepository.findAll().size());
		
	}
	
	@Test
	public void t1(){
		System.out.println("--------------------------" + this.getClass().getName());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
