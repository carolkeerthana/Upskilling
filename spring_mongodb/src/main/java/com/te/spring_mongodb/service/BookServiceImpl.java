package com.te.spring_mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.spring_mongodb.bean.Book;
import com.te.spring_mongodb.dao.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository repository;

	@Override
	public Book addBook(Book book) {
		
		return repository.insert(book);
	}

	@Override
	public Book getBook(Integer id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		Book book2 = repository.findById(book.getId()).get();
		book2.setId(book.getId());
		book2.setAuthorName(book.getAuthorName());
		book2.setBookName(book.getBookName());
		return repository.save(book2);
	}

}
