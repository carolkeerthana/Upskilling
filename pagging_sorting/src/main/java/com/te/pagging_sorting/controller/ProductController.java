package com.te.pagging_sorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.pagging_sorting.entity.Product;
import com.te.pagging_sorting.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/get")
	public ResponseEntity<?> getProduct(){
		List<Product> findAllProducts = service.findAllProducts();
		return new ResponseEntity<List<Product>>(findAllProducts, HttpStatus.OK);
		
	}
	
	@GetMapping("/sort/{field}")
	public ResponseEntity<?> getProductsSorted(@PathVariable String field){
		List<Product> findProductsWithSorting = service.findProductsWithSorting(field);
		return new ResponseEntity<List<Product>>(findProductsWithSorting, HttpStatus.OK);
		
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public ResponseEntity<?> getProductsWithPagination(@PathVariable Integer offset,@PathVariable Integer pageSize){
		Page<Product> findProductsWithPagination = service.findProductsWithPagination(offset, pageSize);
		return new ResponseEntity<Page<Product>>(findProductsWithPagination, HttpStatus.OK);
		
	}
	@GetMapping("/pagingSorting/{offset}/{pageSize}/{field}")
	public ResponseEntity<?> getProductsWithPaginationAndSorting(@PathVariable Integer offset,@PathVariable Integer pageSize,@PathVariable String field){
		Page<Product> findProductsWithPaginationAndSorting = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new ResponseEntity<Page<Product>>(findProductsWithPaginationAndSorting, HttpStatus.OK);
		
	}
}
