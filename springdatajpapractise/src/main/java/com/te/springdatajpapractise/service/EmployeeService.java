package com.te.springdatajpapractise.service;

import java.util.List;

import com.te.springdatajpapractise.bean.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public Employee findByEmpId(Integer empId);
	
	public List<Employee> findByEmpName(String empName);
	
	public Employee updateEmployee(Employee employee, Integer empId);

	public void deleteEmployee(Integer empId);


}
