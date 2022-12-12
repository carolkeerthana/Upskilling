package com.te.spring_mongodb.bean;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
	@Id
	private Integer pid;
	
	private String publisherName;

}
