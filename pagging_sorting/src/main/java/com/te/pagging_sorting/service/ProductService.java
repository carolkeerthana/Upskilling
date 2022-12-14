package com.te.pagging_sorting.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.te.pagging_sorting.entity.Product;

public interface ProductService {
	
	public List<Product> findAllProducts();
	
	public List<Product> findProductsWithSorting(String field);
	
	public Page<Product> findProductsWithPagination(Integer offset, Integer pageSize);
	
	public Page<Product> findProductsWithPaginationAndSorting(Integer offset, Integer pageSize, String field);

}
