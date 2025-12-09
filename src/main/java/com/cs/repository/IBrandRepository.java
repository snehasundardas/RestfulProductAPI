package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.entity.Brand;
import com.cs.entity.Product;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {

	@Query("SELECT p FROM Product p WHERE p.brand.brandName = :brand")
	public List<Product> findAllProductByBrand(@Param("brand") String brand);
	
	
}
