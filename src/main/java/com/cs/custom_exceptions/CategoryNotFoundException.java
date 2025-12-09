package com.cs.custom_exceptions;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException() {
		super();
	}
	public CategoryNotFoundException(String msg) {
		super(msg);
	}
	public CategoryNotFoundException(int id) {
		super("Category Not Found With Id :: "+id);
	}
}
