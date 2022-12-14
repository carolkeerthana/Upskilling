package com.te.springbootchennai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootchennai.bean.EmployeeInfo;
import com.te.springbootchennai.bean.EmployeeResponse;
import com.te.springbootchennai.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(path="/user/{id}")
	public ResponseEntity<EmployeeResponse> getUserData(@PathVariable("id") Integer id){
		System.out.println("id");
		System.out.println(id);
		EmployeeResponse response = new EmployeeResponse(false, service.getEmployee(id));
		return new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping(path = "/insert")
	public ResponseEntity<EmployeeResponse> storeData(@Valid@RequestBody EmployeeInfo info){
		System.out.println(info);
		EmployeeInfo info1=service.register(info);
		EmployeeResponse response = new EmployeeResponse(false, service.register(info));
		return new ResponseEntity<EmployeeResponse>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<EmployeeResponse> storeData(@PathVariable("id") Integer id){
		
		boolean result=service.delete(id);
		EmployeeResponse response = new EmployeeResponse(false, "Deleted Successfully");
		return new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
	}
	

	@PutMapping(path = "/update")
	public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeInfo info){
		EmployeeResponse response = new EmployeeResponse(false, service.update(info));
		return new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
	}
	
	
//	@GetMapping(path = "/user/{id}/{name}")
	//public ResponseEntity<EmployeeResponse> getByIdAndName(
		//	@PathVariable Integer id , @PathVariable String name){
		//EmployeeResponse response = new EmployeeResponse(false, service.getData(id, name));
		//return new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
	//}
}






