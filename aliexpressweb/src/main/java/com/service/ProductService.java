package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {

	public void saveProduct(Product product);

	public List<Product> findAllProducts();

	public void removeProductByName(String name);
	
	public void editProduct(String oldnName, String newName, int newPrice, int newQuantity);
	
}
