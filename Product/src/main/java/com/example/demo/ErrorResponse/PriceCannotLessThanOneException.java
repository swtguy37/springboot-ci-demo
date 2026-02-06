package com.example.demo.ErrorResponse;

public class PriceCannotLessThanOneException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PriceCannotLessThanOneException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
