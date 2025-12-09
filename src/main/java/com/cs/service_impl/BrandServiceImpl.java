package com.cs.service_impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.entity.Brand;
import com.cs.entity.Category;
import com.cs.entity.Product;
import com.cs.repository.IBrandRepository;
import com.cs.service_interfaces.IBrandMgmtService;
import com.cs.utils.UpperCaseUtils;

@Service
public class BrandServiceImpl implements IBrandMgmtService {

	@Autowired
	private IBrandRepository brandRepo;

	public BrandServiceImpl() {
		System.out.println("BrandServiceImpl :: 0- Param Constructor");
	}// method

	@Override
	public String registerBrand(Brand brand) {

		// convert all string properties to Uppercase
		brand = UpperCaseUtils.convertBrandPropertiesIntoUpperCase(brand);

		// save using repo
		Brand savedBrand = brandRepo.save(brand);

		return "Successfully Brand Registerd With id :: " + savedBrand.getBrandId();
	}// method

	@Override
	public List<Brand> findAllBrands() {
		return brandRepo.findAll();
	}// method

	@Override
	public String registerAllBrands(List<Brand> brands) {
		// convert all props into uppercase
		brands = brands.stream().map(UpperCaseUtils::convertBrandPropertiesIntoUpperCase).collect(Collectors.toList());

		// save all brand
		List<Brand> list = brandRepo.saveAll(brands);

		// find all the ids of saved brands
		List<Integer> ids = list.stream().map(Brand::getBrandId).collect(Collectors.toList());

		return "Successfully Registerd All Brands Having Ids :: " + ids;
	}

	@Override
	public Optional<Brand> findBrandById(int id) {
		return brandRepo.findById(id);
	}// method

	@Override
	public List<Product> findAllProductByBrand(String brand) {
		return brandRepo.findAllProductByBrand(brand.toUpperCase());
	}// method
	

}// class
