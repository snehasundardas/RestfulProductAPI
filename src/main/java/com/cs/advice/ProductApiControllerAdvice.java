package com.cs.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.custom_exceptions.BrandNotFoundException;
import com.cs.custom_exceptions.CategoryNotFoundException;
import com.cs.custom_exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductApiControllerAdvice {
	
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<String> handleBrandNotFoundException(BrandNotFoundException bnf){
		String msg = "Sorry Brand Brand Not Found !!";
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException cnf){
		String msg = "Sorry Category Not Found !!";
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException pnf){
		String msg = "Sorry Product Not Found !!";
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
	
	
}
