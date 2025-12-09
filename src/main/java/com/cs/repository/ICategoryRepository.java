package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.entity.Category;
import com.cs.entity.Product;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {


	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category")
	List<Product> findAllProductByCategory(@Param("category") String category);
	
}
