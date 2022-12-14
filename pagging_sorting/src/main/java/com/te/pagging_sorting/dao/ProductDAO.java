package com.te.pagging_sorting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pagging_sorting.entity.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

}
