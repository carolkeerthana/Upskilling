package com.te.stream.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.te.stream.bean.Employee;

public interface EmployeeService {
	
	public void  addEmployee(Employee employee);
	
	public Map<String, Long> noOfMaleAndFemale();
	
	public List<String> getDepartmentNames();
	
	public Optional<Employee> getMaxSalary();
	
	public List<String> empNames();

}
