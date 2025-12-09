package com.cs.service_impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.entity.Category;
import com.cs.entity.Product;
import com.cs.repository.ICategoryRepository;
import com.cs.service_interfaces.ICategoryMgmtServie;
import com.cs.utils.UpperCaseUtils;

@Service
public class CategoryMgmtServiceImpl implements ICategoryMgmtServie {

	@Autowired
	private ICategoryRepository categoryRepo;
	
	public CategoryMgmtServiceImpl() {
		System.out.println("CategoryMgmtServiceImpl :: 0- Param Constructor");
	}

	@Override
	public String saveCategory(Category category) {
		//convert string props into uppercase
		category = UpperCaseUtils.convertCategoryPropertiesIntoUpperCase(category);
		//save using repository
		Category savedCategory = categoryRepo.save(category);
		
		return "Category Successfully  Saved With Id :: "+savedCategory.getCategoryId();
	}//method
	
	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}//method
	
	@Override
	public Optional<Category> findCategoryById(int id) {
		return categoryRepo.findById(id);
	}//method
	
	@Override
	public String registerAllCategories(List<Category> list) {
		//convert all properties to uppercasee
		 list = list.stream().map(UpperCaseUtils::convertCategoryPropertiesIntoUpperCase).collect(Collectors.toList());
		 
		 //saveAll() list
		 List<Category> savedList = categoryRepo.saveAll(list);
		  
		 //find all ids
		 List<Integer> ids = savedList.stream().map(Category::getCategoryId).collect(Collectors.toList());
		 
		return "All Categories Saved With Id :: "+ids;
	}//method
	
	@Override
	public List<Product> findAllProductsByCategory(String category) {
		return categoryRepo.findAllProductByCategory(category.toUpperCase());
	}//method

}//class
