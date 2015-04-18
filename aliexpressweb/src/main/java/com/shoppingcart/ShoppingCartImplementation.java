package com.shoppingcart;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.ProductDaoImplementation;
import com.model.Product;

@Component
public class ShoppingCartImplementation implements ShoppingCartOperations {

	List<ShoppingCartItem> cart;
	
	@Autowired
	ProductDaoImplementation productDao;
	
	public ShoppingCartImplementation() {
		this.cart = new ArrayList<ShoppingCartItem>();
	}

	public void addProductAndQuantity(String productName, int quantity) {
		cart.add(new ShoppingCartItem(productName, quantity));
	}

	public List<ShoppingCartItem> showProductsInCart() {
		return (ArrayList<ShoppingCartItem>) cart;
	}

	public int totalPaymentSum() {
		int totalSum = 0;
		for (ShoppingCartItem item : cart) {
			int quantity = item.getQuantity();
			totalSum += getPriceByProductName(item.getName()) * quantity;
		}
		return totalSum;
	}

	public int getPriceByProductName(String productName) {
		int price = 0;
		List<Product> products = productDao.listProducts();
		for (Product p : products) {
			if (p.getProductName().equals(productName)) {
				price = p.getProductPrice();
			}
		}
		return price;
	}

	@Override
	public Product getProductById(int id) {
		Product getProduct = new Product();
		List<Product> products = productDao.listProducts();
		for (Product p : products) {
			if (p.getId() == id) {
				getProduct = p;
			}
		}
		return getProduct;
	}
}
