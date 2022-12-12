package com.te.spring_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_mongodb.bean.Book;
import com.te.spring_mongodb.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		Book addBook = service.addBook(book);
		return new ResponseEntity<String>("Book details inserted", HttpStatus.OK);
		
	}
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<?> getBook(@PathVariable Integer id){
		Book book = service.getBook(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id){
		service.deleteById(id);
		return new ResponseEntity<String>("deleted the id "+id,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Integer id,@RequestBody Book book){
		Book updateBook = service.updateBook(book, id);
		return new ResponseEntity<Book>(updateBook, HttpStatus.OK);
	}

}
