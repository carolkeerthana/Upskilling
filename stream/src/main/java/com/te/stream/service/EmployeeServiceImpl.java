package com.te.stream.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.stream.bean.Employee;
import com.te.stream.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public void addEmployee(Employee employee) {
		dao.save(employee);

	}

	@Override
	public Map<String, Long> noOfMaleAndFemale() {
		Map<String, Long> collect = dao.findAll().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		return collect;
	}

	@Override
	public List<String> getDepartmentNames() {
		List<String> collect = dao.findAll().stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		return collect;

	}

	@Override
	public Optional<Employee> getMaxSalary() {
		Optional<Employee> collect = dao.findAll().stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		return collect;
	}

	@Override
	public List<String> empNames() {
		List<String> collect = dao.findAll().stream().filter(a->a.getDepartment().contains("developer")).map(Employee::getName).collect(Collectors.toList());
		return collect;
	}

}
