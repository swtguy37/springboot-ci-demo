package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getproduct(int id);
	
	Product addproduct(Product product);
	
	void deleteById(int id);
	
	public Product updateProduct(Product product, int id);
	
	public List<Product> getProdByName(@PathVariable String name);

}
