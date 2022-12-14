package com.te.pdfGenerator.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfImpl implements PdfService {

	@Override
	public void export(HttpServletResponse response) throws  IOException {
		Document document= new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		
		document.open();
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD) ;
		font.setSize(15);
	
		Paragraph paragraph= new Paragraph("This is Title",font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		Font font2= FontFactory.getFont(FontFactory.COURIER);
		font2.setSize(12);
		
		Paragraph paragraph2= new Paragraph("This is a paragraph",font2);
		paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph);
		document.add(paragraph2);
		document.close();
	}

}
