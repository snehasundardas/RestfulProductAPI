package com.cs.service_interfaces;

import java.util.List;
import java.util.Optional;

import com.cs.entity.Brand;
import com.cs.entity.Category;
import com.cs.entity.Product;

public interface IBrandMgmtService {
	
	
	public String registerBrand(Brand brand);

	public List<Brand> findAllBrands();

	public Optional<Brand> findBrandById(int id);
	
	public String registerAllBrands(List<Brand> brands);
	
	public List<Product> findAllProductByBrand(String brand);
	
	
}
