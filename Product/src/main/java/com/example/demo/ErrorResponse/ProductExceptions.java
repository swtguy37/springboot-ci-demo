package com.example.demo.ErrorResponse;

public class ProductExceptions {

	
	String errName;
	String errNo;
	
	ProductExceptions(){}
			
	public ProductExceptions(String errNo, String errName){
		this.errName = errName;
		this.errNo = errNo;
	}
}
