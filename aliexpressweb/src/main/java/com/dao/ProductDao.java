package com.dao;

import java.util.List;

import com.model.Product;


public interface ProductDao {
	
	public void saveProduct(Product product);
	
	public void deleteProductByName(String name);
	
	public void updateProduct(String oldnName, String newName, int newPrice, int newQuantity);	
	
	List<Product> listProducts();
}
