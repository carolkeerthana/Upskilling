package com.te.spring_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.te.spring_mongodb.bean.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
