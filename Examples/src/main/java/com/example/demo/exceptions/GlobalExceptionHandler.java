package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFound.class)
	ResponseEntity<Map<String,String>> handleStudentNotFoundException(StudentNotFound ex){
		
		Map<String, String> errors = new HashMap<String,String>();
		errors.put("error", ex.getMessage());
		
		return new ResponseEntity(errors,HttpStatus.NOT_FOUND);
	}

}
