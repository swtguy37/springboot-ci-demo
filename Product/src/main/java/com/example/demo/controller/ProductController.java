package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ErrorResponse.PriceCannotLessThanOneException;
import com.example.demo.ErrorResponse.ProductExceptions;
import com.example.demo.ErrorResponse.ProductNameException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProdRepository;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productServiceImpl;

	@Autowired
	//ProdRepository prodRepository;
	
	
	@GetMapping
	List<Product> getProducts(){
		
		return productServiceImpl.getAllProducts();
	}
	@GetMapping("/{id}") 
	Product getProductById(@PathVariable int id) {
	
		return productServiceImpl.getproduct(id);
	}
	
	@PostMapping("/addproduct")
	public Product addProduct(@Valid @RequestBody Product product) {
		
		if(product.getPrice() == 12)
			throw new PriceCannotLessThanOneException("Price Cannot be less than 13");
		
		if(product.getpName().equals(""))
				throw new ProductNameException("Name Cannot be empty");
		
		return productServiceImpl.addproduct(product);
	}

	@DeleteMapping("/deleteproduct/{id}")
	public void deleteproduct(@PathVariable int id) {
		 productServiceImpl.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@Valid @RequestBody Product product, @PathVariable int id) {
		return productServiceImpl.updateProduct(product,id);
	}
	
	@GetMapping("/getproduct/{name}")
	public List<Product> getProdByName(@PathVariable String name) {
		 
		 return productServiceImpl.getProdByName(name);
	}
}
