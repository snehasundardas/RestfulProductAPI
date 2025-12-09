package com.cs.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cs.entity.Brand;
import com.cs.entity.Category;
import com.cs.entity.Product;
import com.cs.service_interfaces.IBrandMgmtService;
import com.cs.service_interfaces.ICategoryMgmtServie;
import com.cs.service_interfaces.IProductMgmtService;

@Component
public class ProductAPIRunner implements CommandLineRunner {

	@Autowired
	private IProductMgmtService productService;
	@Autowired
	private IBrandMgmtService brandService;
	@Autowired
	private ICategoryMgmtServie categoryService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 
		//create brand obj
		Brand brand = new Brand("Nike");
		Brand brand2 = new Brand("Adidas");
		Brand brand3 = new Brand("Puma");
		Brand brand4 = new Brand("Woodland");
		Brand brand5 = new Brand("RedTape");
		Brand brand6 = new Brand("Reebook");
		
		String registerMsg = brandService.registerAllBrands(List.of(brand,brand2,brand3,brand4,brand5,brand6));
		System.out.println("Register[Brands] Msg :: "+registerMsg);
		
		//create category Object
		Category c1 = new  Category("Shoes");
		Category c2 = new  Category("Clothing");
		Category c3 = new  Category("Electronics");
		Category c4 = new  Category("Mobiles");
		Category c5 = new  Category("Watches");
		String registerCategoryMsg = categoryService.registerAllCategories(List.of(c1,c2,c3,c4,c5));
		System.out.println("All Category Saved Msg ::"+registerCategoryMsg);
		
		//create Product Object
		Product  product = new Product("Reebook Sports 777", 1199.0);
		product.setBrand(brand6);
		product.setCategory(c1);
		String saveProductMsg = productService.saveProduct(product);
		System.out.println("Product Saved Msg :: [Runner]"+saveProductMsg);
		
		*/
		
	}

}
