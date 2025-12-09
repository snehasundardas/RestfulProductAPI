package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	// ascending
	public List<Product> findAllByOrderByPriceAsc(); 
	// descending
	public List<Product> findAllByOrderByPriceDesc(); 
	
	public List<Product> findByPriceBetween(double min, double max);
	
	/*
	 * Sorting Based On Price And Brand
	@Query("SELECT p FROM Product p WHERE p.brand.brandName = :brand ORDER BY p.price ASC")
	List<Product> getProductsByBrandSortedPriceAsc(@Param("brand") String brand);

	@Query("SELECT p FROM Product p WHERE p.brand.brandName = :brand ORDER BY p.price DESC")
	List<Product> getProductsByBrandSortedPriceDesc(@Param("brand") String brand);
	
	*/
	
	/*
	 * Sorting Based On Price And Category
	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category ORDER BY p.price ASC")
	List<Product> getProductsByCategorySortedPriceAsc(@Param("category") String category);

	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category ORDER BY p.price DESC")
	List<Product> getProductsByCategorySortedPriceDesc(@Param("category") String category);
	
	*/
	
	/*
	  @Query("SELECT p FROM Product p WHERE p.brand.brandName = :brand AND p.price BETWEEN :min AND :max")
	   public List<Product> getProductsByBrandAndPriceRange(@Param("brand") String brand, @Param("min") double min, @Param("max") double max);

	 */

	/*
	 * Filter by Brand and Price Range
	@Query("SELECT p FROM Product p WHERE p.brand.brandName = :brand AND p.price BETWEEN :min AND :max")
	public List<Product> getProductsByBrandAndPriceRange(@Param("brand") String brand, @Param("min") double min, @Param("max") double max);
   */

	/*  
	 * Filter by Category and Price Range
	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category AND p.price BETWEEN :min AND :max")
	public List<Product> getProductsByCategoryAndPriceRange(@Param("category") String category,  @Param("min") double min, @Param("max") double max);
   */
	
}
