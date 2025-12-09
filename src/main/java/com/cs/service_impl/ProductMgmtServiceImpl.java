package com.cs.service_impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.custom_exceptions.BrandNotFoundException;
import com.cs.custom_exceptions.CategoryNotFoundException;
import com.cs.custom_exceptions.ProductNotFoundException;
import com.cs.entity.Brand;
import com.cs.entity.Category;
import com.cs.entity.Product;
import com.cs.repository.IProductRepository;
import com.cs.service_interfaces.IBrandMgmtService;
import com.cs.service_interfaces.ICategoryMgmtServie;
import com.cs.service_interfaces.IProductMgmtService;
import com.cs.utils.UpperCaseUtils;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {

	@Autowired
	private IProductRepository productRepo;
	
	@Autowired
	private IBrandMgmtService brandService;
	
	@Autowired
	private ICategoryMgmtServie categoryMgmtServie;

	public ProductMgmtServiceImpl() {
		System.out.println("ProductMgmtServiceImpl :: 0-Param Constructor ");
	}// constructor

	@Override
	public String saveProduct(Product product) {
		
		//convert props to uppercase
	   product	 = UpperCaseUtils.convertProductPropertiesIntoUpperCase(product);
	   
	   System.out.println("Product After UpperCase utils :: "+product);
	   
	   //get brand
	   Brand brandById = brandService.findBrandById(product.getBrand().getBrandId()).orElseThrow(BrandNotFoundException::new); 
	   
	   //get category
	   Category category = categoryMgmtServie.findCategoryById(product.getCategory().getCategoryId()).orElseThrow(CategoryNotFoundException::new);
	   //set brand and category
	   product.setBrand(brandById);
	   product.setCategory(category);
		
		// save the obj
		Product savedProduct = productRepo.save(product);
		System.out.println("Saved Product Is (Service) ::" + savedProduct);
		return "Product Saved Successfully With Id :: " + savedProduct.getId();
	}// method

	@Override
	public List<Product> findAllProducts() {
		// fetch all products
		List<Product> allProducts = productRepo.findAll();
		System.out.println("All Products In ProductService :: " + allProducts);
		return allProducts;
	}// method

	@Override
	public Optional<Product> findProductById(int id) {
		return productRepo.findById(id);
	}// method
	
	@Override
	public String saveAllProducts(List<Product> list) {
		//convert properties into string
		list = list.stream().map(UpperCaseUtils::convertProductPropertiesIntoUpperCase).collect(Collectors.toList());
		
		//save all objects
		List<Product> savedList = productRepo.saveAll(list);
		
		//find all ids
		List<Integer> ids = savedList.stream().map(Product::getId).collect(Collectors.toList());
	
		return "All Products Saved With Ids :: "+ids;
	}//method
	
	@Override
	public List<Product> findBetweenPriceRange(double min, double max) {
		return productRepo.findByPriceBetween(min, max);
	}//method
	
	@Override
	public List<Product> findByPriceAsc() {
		return productRepo.findAllByOrderByPriceAsc();
	}//method
	
	@Override
	public List<Product> findByPriceDesc() {
		return productRepo.findAllByOrderByPriceDesc();
	}//method
	
	@Override
	public String updateProductPrice(int productId, double price) {
		//check whether product exists or not
		 Product product = productRepo.findById(productId).orElseThrow(ProductNotFoundException::new);
		 
		 //update the price
		 product.setPrice(price);
		 
		 //save the product
		 productRepo.save(product);
		
		return "Product's Price Having Id ::"+productId+" Have Been Successfully Updated";
	}//method
	
	
}// class
