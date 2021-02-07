package com.oa.pma.dao;

import com.oa.pma.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
	@Override
	List<Employee> findAll();
}
