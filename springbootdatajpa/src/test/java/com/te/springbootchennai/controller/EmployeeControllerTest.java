package com.te.springbootchennai.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.tomcat.util.json.JSONParser;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.springbootchennai.bean.EmployeeInfo;
import com.te.springbootchennai.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	private EmployeeService service;

	

	@Test
	public void testGetEmployee() throws Exception {
		EmployeeInfo info = new EmployeeInfo();
		info.setId(18);
		info.setName("kumar");
		info.setMail("k@mail.com");
		Mockito.when(service.getEmployee(info.getId())).thenReturn(info);
		// System.out.println("calling ()"+result);
		String json1 = mapper.writeValueAsString(info);
		System.out.println("json 1:" + json1);
		mockMvc.perform(get("/user/18").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json1).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.name", Matchers.equalTo("kumar")));

	}

	@Test
	public void testRegisterEmployee() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String json = "{\"id\":1,\"name\":\"Arun\",\"mail\":null,\"pwd\":null,\"dob\":null,\"mobile\":null}";

		EmployeeInfo info = new EmployeeInfo();
		info.setId(1);
		info.setName("Arun");
		Mockito.when(service.register(ArgumentMatchers.any())).thenReturn(info);
		String json1 = mapper.writeValueAsString(info);
		System.out.println("json 1:" + json1);
		mockMvc.perform(post("/insert").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json1).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.data.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.data.name", Matchers.equalTo("Arun")));

	}

	@Test
	public void testDeleteEmployee() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String json = "{\"id\":1,\"name\":\"Arun\",\"mail\":null,\"pwd\":null,\"dob\":null,\"mobile\":null}";
		EmployeeInfo info = new EmployeeInfo();
		info.setId(17);
		boolean result = service.delete(info.getId());
		System.out.println("Result :" + result);
		Mockito.when(service.delete(info.getId())).thenReturn(result);
		// System.out.println("calling ()"+result);
		MvcResult requestResult = mockMvc.perform(delete("/delete/17")).andExpect(status().isOk()).andReturn();
		String result1 = requestResult.getResponse().getContentAsString();

		System.out.println("Result :" + result1);
		assertEquals(result1, "{\"error\":false,\"data\":\"Deleted Successfully\"}");
	}

}
