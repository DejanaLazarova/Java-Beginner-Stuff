package testPackage;

import interfaces.StorageImplementation;

import java.util.Scanner;

import PatternClasses.ShoppingCart;
import PatternClasses.StorageImplementationFactory;

public class HandleUserInput {

	Scanner scanner;
	ShoppingCart cart;

	public HandleUserInput() {
		this.scanner = new Scanner(System.in);
	}

	public void run() {
		askForStorage();
		printMenu();
		boolean end = false;
		while (!end) {
			String action = scanner.next();
			if (action.equals("1")) {
				cart.showProductsInCart();
				end = false;
			} else if (action.equals("2")) {
				System.out.println("Enter product name:");
				scanner.nextLine();
				String productName = scanner.nextLine();
				System.out.println("Enter product quantity:");
				int quantity = scanner.nextInt();
				cart.addProductAndQuantity(productName, quantity);
				end = false;
			} else if (action.equals("3")) {
				System.out.println("Total sum: " + cart.totalPaymentSum());
				end = false;
			} else if (action.equals("end")) {
				end = true;
				System.out.println("BYE.");
				break;
			}
		}
	}

	public void askForStorage() {
		System.out.println("Enter 1 to store products in warehouse;");
		System.out.println("Enter 2 to store products in database JDBC:");
		System.out.println("Enter 3 to store products in database Hibernate:");
		int choice = scanner.nextInt();
		StorageImplementation storageImpl = StorageImplementationFactory.makeStorage(choice);
		storageImpl.persistDataInStorage();
		storageImpl.showDataFromStorage();
		cart = new ShoppingCart(storageImpl);
	}

	public void printMenu() {
		System.out.println("Please choose an action from the list below:");
		System.out.println("Enter 1 to list all products in the warehouse");
		System.out.println("Enter 2 to add a product and a quantity to your basket");
		System.out.println("Enter 3 to proceed to checkout");
		System.out.println("Enter end to exit");
	}
}
