import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StoreProductsInDatabase implements StoreProducts {

	Connection connection = null;
	Statement statement = null;
	BufferedReader buff;
	
	@Override
	public void storeProducts() {
		
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
	                     
			    //prone to sql injection
	                    String query = "INSERT INTO products(uniqueKey, name, price, quantity) VALUES ('" + p.getUniqueKey() + "' , '" + p.getName() + "' , '" + p.getPrice() + "' , '" + p.getQuantity() + "')";
	             		try {
	             			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productsdb", "postgres", "postgres");
	             			 statement = connection.createStatement();
	             			 statement.executeUpdate(query);
	             			 System.out.println("Insert done!");
	             			 
	             		} catch (SQLException e) {             			
	             			e.printStackTrace();
	             		}
	             		finally{
	             			try {
								statement.close();
								connection.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}	             			
	             		}
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
}
