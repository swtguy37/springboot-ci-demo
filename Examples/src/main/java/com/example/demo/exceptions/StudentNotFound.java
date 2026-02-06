package com.example.demo.exceptions;

public class StudentNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFound(String message) {
		super(message);
	}
}
