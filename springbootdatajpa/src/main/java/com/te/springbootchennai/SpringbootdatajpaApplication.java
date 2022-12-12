package com.te.springbootchennai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.te.springbootchennai")
public class SpringbootdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdatajpaApplication.class, args);
	}

}
