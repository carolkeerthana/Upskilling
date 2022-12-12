package com.te.springdatajpapractise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springdatajpapractise.bean.Employee;
import com.te.springdatajpapractise.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody Employee employee){
		Employee addEmployee = service.addEmployee(employee);
		logger.info("adding employee with id - {}",employee.getEmpId());
		return new ResponseEntity<String> ("data inserted", HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/employee/{empId}")
	public ResponseEntity<?> getById(@PathVariable Integer empId,Employee employee){
		Employee findByEmpId = service.findByEmpId(empId);
		logger.info("fetching employee details from db");
		return new ResponseEntity<Employee> (findByEmpId, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable("name") String empName){
		List<Employee> findByEmpName = service.findByEmpName(empName);
		return new ResponseEntity<List<Employee>> (findByEmpName, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<?> updateEmp(@PathVariable Integer empId,@RequestBody Employee employee){
		Employee updateEmployee = service.updateEmployee(employee, empId);
		logger.info("employee detail updated");
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmp(@PathVariable Integer empId, Employee employee){
        service.deleteEmployee(empId);
        logger.info("employee detail deleted");
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		
	}
}
