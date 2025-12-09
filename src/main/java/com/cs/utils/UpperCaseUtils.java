package com.cs.utils;

import com.cs.entity.Brand;
import com.cs.entity.Category;
import com.cs.entity.Product;

public class UpperCaseUtils {
	
	//make constructor private for memory mgmt
	private UpperCaseUtils() {
		System.out.println("Private Constructor");
	}

	public static Brand convertBrandPropertiesIntoUpperCase(Brand brand) { 
		brand.setBrandName(brand.getBrandName().toUpperCase());
		return brand;
	}
	
	public static Category convertCategoryPropertiesIntoUpperCase(Category category) {
		category.setCategoryName(category.getCategoryName().toUpperCase());
		return category;
	}
	
	public static Product convertProductPropertiesIntoUpperCase(Product product){
		product.setName(product.getName().toUpperCase());
		return product;
	}
	
}
