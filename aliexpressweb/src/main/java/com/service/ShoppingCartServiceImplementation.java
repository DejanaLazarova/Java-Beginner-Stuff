package com.service;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.shoppingcart.ShoppingCartImplementation;
import com.shoppingcart.ShoppingCartItem;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService{

	ShoppingCartImplementation shoppingCart;
	
	@Autowired
	public ShoppingCartServiceImplementation(ShoppingCartImplementation shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public void insertProductAndQuantity(String productName, int quantity) {
		shoppingCart.addProductAndQuantity(productName, quantity);	
	}

	@Override
	public List<ShoppingCartItem> showProductsInCart() {
		return shoppingCart.showProductsInCart();
	}

	@Override
	public int sumTotalPayment() {
		return shoppingCart.totalPaymentSum();
	}

	@Override
	public int getPriceByProduct(String productName) {
		return shoppingCart.getPriceByProductName(productName);
	}

	@Override
	public Product getProductById(int id) {
		return shoppingCart.getProductById(id);
	}

}
