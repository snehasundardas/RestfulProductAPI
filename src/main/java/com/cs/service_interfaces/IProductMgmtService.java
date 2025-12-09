package com.cs.service_interfaces;

import java.util.List;
import java.util.Optional;

import com.cs.entity.Product;

public interface IProductMgmtService {
	public String saveProduct(Product product);
	public List<Product> findAllProducts();
    public Optional<Product> findProductById(int id);
    public String saveAllProducts(List<Product> list);
    public List<Product> findByPriceAsc();
    public List<Product> findByPriceDesc();
    public List<Product> findBetweenPriceRange(double startPrice, double endPrice);
    
    
    //UPDATION OF PRODUCTS
    public String updateProductPrice(int productId, double price);
}
