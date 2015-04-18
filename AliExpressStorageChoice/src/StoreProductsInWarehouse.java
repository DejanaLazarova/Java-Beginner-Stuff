import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class StoreProductsInWarehouse implements StoreProducts{
	
	public ArrayList<Product> products;
	private BufferedReader buff;
	
	public StoreProductsInWarehouse(){
		products = new ArrayList<Product>();
	}

	public void storeProducts()
	{
		try {
			FileReader file = new FileReader("products.txt");
			buff = new BufferedReader(file);
			 boolean eof = false;
	            while (!eof) {
	            	String line = buff.readLine();
	                if (line == null) {
	                    eof = true;
	                } 
	                else {
	                     String [] pom = line.split("&");
	                     int price = Integer.valueOf(pom[2]);
	                     int quantity = Integer.valueOf(pom[3]);
	                     Product p = new Product(pom[0],pom[1],price,quantity);
	                     products.add(p);
	                }         
	            }			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	
}
