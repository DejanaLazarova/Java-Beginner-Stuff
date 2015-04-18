package com.shoppingcart;

import java.util.List;

import com.model.Product;

public interface ShoppingCartOperations {
	
	public void addProductAndQuantity(String productName, int quantity);
	
	public List showProductsInCart();
	
	public int totalPaymentSum();
	
	public int getPriceByProductName(String productName);
	
	public Product getProductById(int id);

}
