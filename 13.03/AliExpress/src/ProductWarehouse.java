import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductWarehouse {

	ArrayList<Product> products;
	private BufferedReader buff;
	
	public ProductWarehouse()
	{
		products = new ArrayList<Product>();
	}
	
	public void StoreProductsInWarehouse() throws IOException
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
			buff.close();
		}	
	}
	
	public void printProductsInWarehouse()
	{
		for(Product p: products)
		{
			p.printProducts();
		}
	}
	
	public int getPriceByProduct(String product)
	{
		int price = 0;
		for(Product p: products)
		{
			if(p.getName().equals(product))
			{
				price = p.getPrice();
			}
		}
		return price;
	}

}
