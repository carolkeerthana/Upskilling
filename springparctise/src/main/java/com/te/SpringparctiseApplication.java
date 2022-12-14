package com.te;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringparctiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringparctiseApplication.class, args);
	}

}
