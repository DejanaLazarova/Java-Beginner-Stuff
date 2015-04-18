package com.service;

import java.util.List;
import java.util.Set;

import com.model.Product;

public interface ShoppingCartService {
	
	public void insertProductAndQuantity(String productName, int quantity);
	
	public List showProductsInCart();
	
	public int sumTotalPayment();
	
	public int getPriceByProduct(String productName);
	
	public Product getProductById(int id);
}
