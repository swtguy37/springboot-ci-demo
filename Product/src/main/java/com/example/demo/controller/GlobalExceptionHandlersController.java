package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.ErrorResponse.PriceCannotLessThanOneException;
import com.example.demo.ErrorResponse.ProductExceptions;
import com.example.demo.ErrorResponse.ProductNameException;

@RestControllerAdvice
public class GlobalExceptionHandlersController {
	
	@ExceptionHandler(PriceCannotLessThanOneException.class)
	public ResponseEntity<ProductExceptions> handleSumException(PriceCannotLessThanOneException ex){
		
		ProductExceptions error = new ProductExceptions("ERR_002", ex.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProductNameException.class)
	public ResponseEntity<ProductExceptions> handleProductNameException(ProductNameException ex) {
		
		ProductExceptions exceptions = new ProductExceptions("ERR_003", ex.getMessage());
		return new ResponseEntity<>(exceptions,HttpStatus.BAD_REQUEST);
	}

}
