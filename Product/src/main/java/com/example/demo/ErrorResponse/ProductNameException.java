package com.example.demo.ErrorResponse;

public class ProductNameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	
	public ProductNameException(String name) {
		super(name);
	}
	
}
