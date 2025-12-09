package com.cs.custom_exceptions;

@SuppressWarnings("serial")
public class BrandNotFoundException extends RuntimeException {
	
	public BrandNotFoundException() {
		super();
	}
	public BrandNotFoundException(String msg) {
		super(msg);
	}
	
	public  BrandNotFoundException(int id) {
		super("Brand Not Found With ID :: "+id);
	}
	
}
