package com.te.pdfGenerator.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pdfGenerator.service.PdfService;

@RestController
//@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private PdfService service;
	
	@GetMapping("/pdf/generate")
	public void pdfGenerate(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String format = dateFormat.format(new Date());
		
		String headerKey= "Content-Disposition";
		String headerValue="attachment; filename=pdf_" +format+".pdf";
		response.setHeader(headerKey, headerValue);
		this.service.export(response);
		
	}
	
}
