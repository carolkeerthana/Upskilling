package com.te.spring_mongodb_autosequence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.spring_mongodb_autosequence.dao.BookDAO;
import com.te.spring_mongodb_autosequence.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDAO dao;
	
	@Autowired
	private SequenceGeneratorService generatorService;

	@Override
	public Book addBook(Book book) {
		book.setId(generatorService.getSequenceNumber(book.SEQUENCE_NAME));		
		return dao.insert(book);
	}

	@Override
	public List<com.te.spring_mongodb_autosequence.entity.Book> Book() {
		
		return dao.findAll();
	}
	
	

}
