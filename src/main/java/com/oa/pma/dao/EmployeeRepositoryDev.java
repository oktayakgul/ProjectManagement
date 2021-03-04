package com.oa.pma.dao;

import com.oa.pma.dto.EmployeeProjects;
import com.oa.pma.entity.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class EmployeeRepositoryDev implements EmployeeRepository {
	
	public List<Employee> findAll(){
		Employee employee1 = new Employee("AAA","EEE","OOO");
		Employee employee2 = new Employee("BBB","CCC","DDD");
		
		return Arrays.asList(employee1,employee2);
	}
	
	@Override
	public Iterable<Employee> findAllById(Iterable<Long> longs) {
		return null;
	}
	
	@Override
	public <S extends Employee> S save(S entity) {
		return null;
	}
	
	@Override
	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}
	
	@Override
	public Optional<Employee> findById(Long aLong) {
		return Optional.empty();
	}
	
	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
	
	
	@Override
	public long count() {
		return 0;
	}
	
	@Override
	public void deleteById(Long aLong) {
	
	}
	
	@Override
	public void delete(Employee entity) {
	
	}
	
	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
	
	}
	
	@Override
	public void deleteAll() {
	
	}
	
	@Override
	public List<EmployeeProjects> employeeProjects() {
		List<EmployeeProjects> employeeProjectList = new ArrayList<>();
		EmployeeProjects       employee = new EmployeeProjects() {
			@Override
			public String getFirstName() {
				return "A1";
			}
			
			@Override
			public String getLastName() {
				return "A2";
			}
			
			@Override
			public int getProjectCount() {
				return 0;
			}
		};
		employeeProjectList.add(employee);
		return employeeProjectList;
	}
}
