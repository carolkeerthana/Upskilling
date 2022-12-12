package com.te.springbootchennai.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeInfoTest {
	String json = "{\"id\":100,\"name\":\"Ram\",\"mail\":\"aa@gmail.com\",\"pwd\":\"aaa\",\"dob\":null,\"mobile\":97868}";
	ObjectMapper mapper = new ObjectMapper();

	@org.junit.jupiter.api.Test
	void test() throws JsonProcessingException, ParseException {
		EmployeeInfo info = new EmployeeInfo();
System.out.println("welcome");
		info.setId(100);
		info.setName("Ram");
		info.setPwd("aaa");
		//info.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("12-12-2000"));
		info.setMail("aa@gmail.com");
		info.setMobile(97868L);
		System.out.println(mapper.writeValueAsString(info));

		EmployeeInfo readValue = mapper.readValue(json, EmployeeInfo.class);
		System.out.println(mapper.writeValueAsString(readValue));
		assertEquals(json, mapper.writeValueAsString(readValue));

	}

}
