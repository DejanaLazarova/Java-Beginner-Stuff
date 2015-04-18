package com;

import java.util.List;
import java.util.Scanner;

import com.dao.ProductDaoImplementation;
import com.model.Product;
import com.service.ProductServiceImplementation;
import com.service.ShoppingCartServiceImplementation;
import com.shoppingcart.ShoppingCartImplementation;
import com.shoppingcart.ShoppingCartItem;

public class HandleUserInput {

	ProductServiceImplementation productService;
	ShoppingCartServiceImplementation cartService;
	Scanner scanner;

	public HandleUserInput() {
		super();
		this.productService = new ProductServiceImplementation(
				new ProductDaoImplementation());
		this.cartService = new ShoppingCartServiceImplementation(
				new ShoppingCartImplementation());
		this.scanner = new Scanner(System.in);
	}

	public void run() {
		printMenu();
		boolean end = false;
		while (!end) {
			String action = scanner.next();
			if (action.equals("1")) {
				List<Product> products = productService.findAllProducts();
				for (Product p : products) {
					System.out.println(" Name: " + p.getProductName() +
							" Price: " + p.getProductPrice()
							+ " Quantity: " + p.getProductQuantity());
				}
				end = false;
			} else if (action.equals("2")) {
				System.out.println("Enter product and quantity");
				scanner.nextLine();
				String productName = scanner.nextLine();
				int quantity = scanner.nextInt();
				cartService.insertProductAndQuantity(productName, quantity);
				System.out.println("Sucess!");
				end = false;
			} else if (action.equals("3")) {
				List<ShoppingCartItem> cart = cartService.showProductsInCart();
				for (ShoppingCartItem shoppingCartItem : cart) {
					System.out.println("Name: " + shoppingCartItem.getName()
							+ " Quantity: " + shoppingCartItem.getQuantity());
				}
				end = false;
			} else if (action.equals("4")) {
				//System.out.println("Total payment sum: " + cartService.sumTotalPayment());
				end = false;
			} else if (action.equals("end")) {
				end = true;
				System.out.println("BYE.");
				break;
			}
		}
	}

	public void printMenu() {
		System.out.println("Please choose an action from the list below:");
		System.out.println("Enter 1 to list all products in the warehouse");
		System.out.println("Enter 2 to add a product and a quantity to your basket");
		System.out.println("Enter 3 to list products in basket");
		System.out.println("Enter 4 to proceed to checkout");
		System.out.println("Enter end to exit");
	}
}
