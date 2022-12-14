package com.te.pagging_sorting.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.pagging_sorting.dao.ProductDAO;
import com.te.pagging_sorting.entity.Product;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO dao;
	
//	@PostConstruct
//	public void initDB() {
//		List<Product> products = IntStream.range(1, 200)
//				.mapToObj(i->new Product("product"+i, new Random().nextInt(100), new Random().nextLong(50000)))
//				.collect(Collectors.toList());
//		dao.saveAll(products);
//	}

	@Override
	public List<Product> findAllProducts() {
		
		return dao.findAll();
	}

	@Override
	public List<Product> findProductsWithSorting(String field) {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Product> findProductsWithPagination(Integer offset, Integer pageSize) {
		
		Page<Product> products = dao.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

	@Override
	public Page<Product> findProductsWithPaginationAndSorting(Integer offset, Integer pageSize, String field) {
		Page<Product> page = dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return page;
	}

}
