package PatternClasses;

import EntityClasses.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.StorageImplementation;

public class InMemoryStorage implements StorageImplementation {

	public ArrayList<Product> products;
	private BufferedReader buff;

	public InMemoryStorage() {
		products = new ArrayList<Product>();
	}

	public void persistDataInStorage() {
		try {
			FileReader file = new FileReader("products.txt");
			buff = new BufferedReader(file);
			String line = "";
			while ((line = buff.readLine()) != null) {

				String[] pom = line.split("&");
				int price = Integer.valueOf(pom[2]);
				int quantity = Integer.valueOf(pom[3]);
				Product p = new Product(Integer.valueOf(pom[0]), pom[1], price,quantity);
				products.add(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList getDataFromStorage() {
		return products;
	}

	public void showDataFromStorage() {

		for (Product p : products) {
			System.out.println(p.getId() + " " + p.getProductName() + " "
					+ p.getProductPrice() + " " + p.getProductQuantity());
		}

	}
}
