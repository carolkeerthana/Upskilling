package com.te.springbootchennai.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.te.springbootchennai.bean.EmployeeInfo;
import com.te.springbootchennai.dao.EmployeeDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeDAO dao;

	@Test
	public void registerTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EmployeeInfo info = new EmployeeInfo(100, "Raj", "raj@gmail.com", "rr", sdf.parse("12/12/2000"), 2321321L);
		when(service.register(info)).thenReturn(info);
		assertEquals(info, service.register(info));
	}

	@Test
	public void deleteTest() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EmployeeInfo info = new EmployeeInfo(100, "Raj", "raj@gmail.com", "rr", sdf.parse("12/12/2000"), 2321321L);
		service.delete(info.getId());
		verify(dao, times(1)).deleteById(info.getId());
	}
	
	@Test
	public void updateTest() {
		EmployeeInfo info=new EmployeeInfo();
		info.setMail("up@gmail.com");
		service.update(info);
		when(service.update(info)).thenReturn(info);
		System.out.println(info.toString());
		assertEquals(info, service.update(info));
	}
	
	@Test
	public void getTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		EmployeeInfo info = new EmployeeInfo(100, "Raj", "raj@gmail.com", "rr", sdf.parse("12/12/2000"), 2321321L);
		when(dao.findById(100)).thenReturn(Optional.ofNullable(info));
		assertThat(service.getEmployee(info.getId())).isEqualTo(info);
	}
}
