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

import com.cs.custom_exceptions.CategoryNotFoundException;
import com.cs.entity.Category;
import com.cs.service_interfaces.ICategoryMgmtServie;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
	
    @Autowired 
    private ICategoryMgmtServie categoryService;

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody Category category) {
      System.out.println("Category Object From Postman :: "+category);
      String  msg = categoryService.saveCategory(category);
      return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    }//method

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> list = categoryService.findAll();
        return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
    }//method
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Category>  findCategoryById(@PathVariable("id") int id)   {
    	//use service
    	Category category = categoryService.findCategoryById(id).orElseThrow(CategoryNotFoundException::new);
    	return new ResponseEntity<Category>(category,HttpStatus.OK);
    }
}//class
