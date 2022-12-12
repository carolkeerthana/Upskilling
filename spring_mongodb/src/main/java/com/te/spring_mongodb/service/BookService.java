package com.te.spring_mongodb.service;

import com.te.spring_mongodb.bean.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public Book getBook(Integer id);
	
	public Book updateBook(Book book, Integer id);
	
	public void deleteById(Integer id);

}
