package com.te.stream.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    String name;
     
    Integer age;
     
    String gender;
     
    String department;
     @JsonFormat(pattern = "dd/MM/yyyy")
    String yearOfJoining;
     
    Double salary;

}
