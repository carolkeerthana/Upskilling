package com.te.stream.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.stream.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
