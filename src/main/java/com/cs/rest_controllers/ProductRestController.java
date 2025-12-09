package com.cs.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.custom_exceptions.ProductNotFoundException;
import com.cs.entity.Product;
import com.cs.service_interfaces.IBrandMgmtService;
import com.cs.service_interfaces.ICategoryMgmtServie;
import com.cs.service_interfaces.IProductMgmtService;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	
	@Autowired
	private IProductMgmtService productService;

	@Autowired
	private IBrandMgmtService brandService;
	
	@Autowired
	private ICategoryMgmtServie categoryService;
	


	@GetMapping("findById/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
         Product product = productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
         return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
	
	@PostMapping("/save")
	public ResponseEntity<String> registerProduct(@RequestBody Product product) {
		System.out.println("Product From Postman :: "+product);
		String msg = productService.saveProduct(product);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}//method

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		 List<Product> products = productService.findAllProducts();
		 return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}//method
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<Product>> findAllProductsByBrand(@PathVariable String brand){
		List<Product> allProductByBrand = brandService.findAllProductByBrand(brand);
		return new ResponseEntity<List<Product>>(allProductByBrand,HttpStatus.OK);
	}//

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Product>> findAllProductsByCategory(@PathVariable String category){
		List<Product> allProductByCategory = categoryService.findAllProductsByCategory(category);
		return new ResponseEntity<List<Product>>(allProductByCategory,HttpStatus.OK);
	}//method
	
	@GetMapping("/price-asc")
	public ResponseEntity<List<Product>> findProductByPriceByAscending(){
		return new  ResponseEntity<List<Product>>(productService.findByPriceAsc(),HttpStatus.OK);
	}//method
	
	@GetMapping("/price-desc")
	public ResponseEntity<List<Product>> findProductByPriceByDescending(){
		return new  ResponseEntity<List<Product>>(productService.findByPriceDesc(),HttpStatus.OK);
	}//method
	
	@GetMapping("/range/{min}/{max}")
	public ResponseEntity<List<Product>> findProductsInRangeOfPrice(@PathVariable double min, @PathVariable double max){
		return new ResponseEntity<List<Product>>(productService.findBetweenPriceRange(min, max),HttpStatus.OK);
	}//method
	
	
	@PatchMapping("/update/{id}/{price}")
	public ResponseEntity<String> updateProductPrice(@PathVariable("id") int productId, @PathVariable double price){
		return new ResponseEntity<String>(productService.updateProductPrice(productId, price),HttpStatus.OK);
	}//method

	
	
}//class
