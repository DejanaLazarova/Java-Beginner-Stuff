package interfaces;

import java.util.ArrayList;

import EntityClasses.Product;

public interface StorageImplementation {
	
	public void persistDataInStorage();
	
	public ArrayList<Product> getDataFromStorage();
	
	public void showDataFromStorage();
}
