package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProdRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProdRepository prodRepository;
//	static List<Product> lstProducts = Arrays.asList(
//			new Product(1,"ProdOne",10.00),
//			new Product(2,"ProdOne",20.00),
//			new Product(3,"ProdOne",30.00)
//			);
//	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return prodRepository.findAll();
	}

	@Override
	public Product getproduct(int id) {
		// TODO Auto-generated method stub
		//return lstProducts.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		return prodRepository.findById(id).orElse(null);
	}

	@Override
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		return prodRepository.save(product);
	}
	
	public Product updateProduct(Product product, int id) {
		
		return prodRepository.findById(id).map(prod -> 
				{
					prod.setpName(product.getpName());
					prod.setPrice(product.getPrice());
					
					return prodRepository.save(product);
				}).orElseThrow(()-> new RuntimeException("No Product with Id " + id));
		
	}
	
	public void deleteById(int intId) {
		
		prodRepository.deleteById(intId);
	}

	@Override
	public List<Product> getProdByName(String name) {
		// TODO Auto-generated method stub
		
		List<Product> prdName = prodRepository.findBypName(name);
		if(prdName.isEmpty()) 
			throw new RuntimeException("No Product with name " + name);
		return prdName;
	}

}
