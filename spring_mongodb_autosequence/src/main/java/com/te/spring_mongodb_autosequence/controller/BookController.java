package com.te.spring_mongodb_autosequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_mongodb_autosequence.entity.Book;
import com.te.spring_mongodb_autosequence.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping("/savebook")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		Book addBook = service.addBook(book);
		return new ResponseEntity<String>("Book inserted successfully", HttpStatus.OK);
		
	}

}
