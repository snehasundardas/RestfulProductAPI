package com.cs.custom_exceptions;


@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}
	public ProductNotFoundException(int id) {
		super("Product Not Found With Id :: "+id);
	}
	

	

}
