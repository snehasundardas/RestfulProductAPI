package com.cs.service_interfaces;

import java.util.List;
import java.util.Optional;

import com.cs.entity.Category;
import com.cs.entity.Product;

public interface ICategoryMgmtServie {
	public String saveCategory(Category category);
    public String registerAllCategories(List<Category> list);
	public List<Category> findAll();
	public Optional<Category> findCategoryById(int id);
	public List<Product> findAllProductsByCategory(String category);
}
