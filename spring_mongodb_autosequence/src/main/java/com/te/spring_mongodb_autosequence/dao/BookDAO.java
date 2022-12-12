package com.te.spring_mongodb_autosequence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.spring_mongodb_autosequence.entity.Book;
@Repository
public interface BookDAO extends MongoRepository<Book, Integer>{

}
