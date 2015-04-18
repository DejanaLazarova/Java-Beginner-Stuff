package PatternClasses;

import java.util.Hashtable;
import java.util.Set;

import EntityClasses.Product;
import interfaces.ShoppingCartOperations;
import interfaces.StorageImplementation;

public class ShoppingCart implements ShoppingCartOperations {

	Hashtable<String, Integer> cart;
	StorageImplementation storage;

	public ShoppingCart(StorageImplementation storage) {
		this.cart = new Hashtable<String, Integer>();
		this.storage = storage;
	}

	public void addProductAndQuantity(String productName, Integer quantity) {
		cart.put(productName, quantity);
	}

	public void showProductsInCart() {
		Set<String> products = cart.keySet();
		for (String product : products) {
			System.out.println("Product: " + product + " Quantity: "
					+ cart.get(product) + " Price: "
					+ getPriceByProductName(product));
		}
	}

	public int totalPaymentSum() {
		int totalSum = 0;
		Set<String> products = cart.keySet();
		for (String product : products) {
			int quantity = cart.get(product);
			totalSum += getPriceByProductName(product) * quantity;
		}
		return totalSum;
	}

	// for program simplification, it currently takes the price from the in
	// memory list.
	// otherwise, there should be jdbc & hibernate implementations added

	public int getPriceByProductName(String productName) {
		int price = 0;
		for (Product p : storage.getDataFromStorage()) {
			if (p.getProductName().equals(productName)) {
				price = p.getProductPrice();
			}
		}
		return price;
	}
}
