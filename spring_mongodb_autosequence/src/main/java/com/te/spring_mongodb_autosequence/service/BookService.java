package com.te.spring_mongodb_autosequence.service;

import java.util.List;

import com.te.spring_mongodb_autosequence.entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public List<Book> Book();

}
