package com.te.springdatajpapractise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.te.springdatajpapractise.bean.Employee;
import com.te.springdatajpapractise.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return dao.save(employee);
	}

	@Override
	@Cacheable(cacheNames = "employee", key = "#empId")
	public Employee findByEmpId(Integer empId) {
		
		return dao.findById(empId).get();
	}

	@Override
	public List<Employee> findByEmpName(String empName) {
		
		return dao.findByEmpName(empName);
	}

	@Override
	@CachePut(cacheNames = "employee", key = "#employee.empId" )
	public Employee updateEmployee(Employee employee, Integer empId) {
		Employee employee2 = dao.findById(employee.getEmpId()).get();
		employee2.setEmpName(employee.getEmpName());
		employee2.setDateOfJoining(employee.getDateOfJoining());
		return dao.save(employee2);
	}

	@Override
	@CacheEvict(cacheNames = "employee", key = "#empId")
	public void deleteEmployee(Integer empId) {
		dao.deleteById(empId);
		
	}

	

	
	
	
	

}
