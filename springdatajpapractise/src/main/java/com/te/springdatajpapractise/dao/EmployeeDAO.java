package com.te.springdatajpapractise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springdatajpapractise.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	//public List<Employee> findByEmpName();
	
	public List<Employee> findByEmpName(String empName);
	

}
