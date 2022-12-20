package com.te.stream.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.stream.bean.Employee;
import com.te.stream.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDetails(@RequestBody Employee employee){
		service.addEmployee(employee);
		return new ResponseEntity<String>("Data inserted",HttpStatus.OK);
		
	}
	
	@GetMapping("/getgender")
	public ResponseEntity<?> getGender(){
		Map<String, Long> noOfMaleAndFemale = service.noOfMaleAndFemale();
		return new ResponseEntity<Map<String,Long>>(noOfMaleAndFemale,HttpStatus.OK);
		
	}
	@GetMapping("/getdept")
	public ResponseEntity<?> getDepartmentNames(){
		List<String> departmentNames = service.getDepartmentNames();
		return new ResponseEntity<List<String>>(departmentNames,HttpStatus.OK);
		
	}
	@GetMapping("/maxsal")
	public ResponseEntity<?> MaxSalary(){
		Optional<Employee> maxSalary = service.getMaxSalary();
		return new ResponseEntity<Optional<Employee>>(maxSalary,HttpStatus.OK);
		
	}
	@GetMapping("/dev")
	public ResponseEntity<?> getDEvelopers(){
		List<String> empNames = service.empNames();
		return new ResponseEntity<List<String>>(empNames,HttpStatus.OK);
		
	}

}
