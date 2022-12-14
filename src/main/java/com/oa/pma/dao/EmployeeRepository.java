package com.oa.pma.dao;

import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.entity.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

//@Repository
//@Profile("prod")
@RepositoryRestResource(collectionResourceRel = "employeeAPI",path = "employeeAPI")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
	
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery = true,value = "SELECT e.fname firstname, e.lname lastname, COUNT(pe.EMPLOYEE_ID) projectcount " +
			"FROM EMPLOYEE e left join PROJECT_EMPLOYEE  pe on pe.EMPLOYEE_ID = e.ID " +
			"group by e.FNAME ,e.LNAME order by 3 desc")
	List<EmployeeProjects> employeeProjects();
	
	Employee findByEmail(String s); // spring understand
}
