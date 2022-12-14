package com.te.pdfGenerator.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

public interface PdfService {

	public void export(HttpServletResponse response) throws  IOException;
}
