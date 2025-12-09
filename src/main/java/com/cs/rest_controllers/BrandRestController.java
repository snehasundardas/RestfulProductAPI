package com.cs.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.custom_exceptions.BrandNotFoundException;
import com.cs.entity.Brand;
import com.cs.service_interfaces.IBrandMgmtService;

@RestController
@RequestMapping("/brands")
public class BrandRestController {
	
	@Autowired
	private IBrandMgmtService brandService;

	
	@GetMapping("/id/{id}")
	public ResponseEntity<Brand> getBrandById(@PathVariable int id){
		//use service
		Brand brand = brandService.findBrandById(id).orElseThrow(BrandNotFoundException::new);
		return new ResponseEntity<Brand>(brand,HttpStatus.OK);
	}//method

	@PostMapping("/save")
	public ResponseEntity<String> create(@RequestBody Brand brand) {
		System.out.println("Brand From Postman :: "+brand);
		String msg = brandService.registerBrand(brand);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}//method

	@GetMapping("/all")
	public ResponseEntity<List<Brand>> getAll() {
		 List<Brand> allBrands = brandService.findAllBrands();
		 return new ResponseEntity<List<Brand>>(allBrands,HttpStatus.OK);
	}//method
	
	
	
	
}//class
