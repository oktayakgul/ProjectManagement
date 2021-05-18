package com.oa.pma.validatiton;

import com.oa.pma.dao.EmployeeRepository;
import com.oa.pma.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		
		System.out.println("Entered validation method...");
		
		Employee employee = employeeRepository.findByEmail(s);
		
		System.out.println(employee != null);
		
		if(employee != null)
			return false;
		else
			return true;
	}
}
