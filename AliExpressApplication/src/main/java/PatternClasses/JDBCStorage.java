package PatternClasses;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EntityClasses.Product;
import interfaces.StorageImplementation;

public class JDBCStorage implements StorageImplementation {

	private BufferedReader buff;
	Connection connection = null;
	PreparedStatement statement = null;
	
	public void persistDataInStorage() {
		try {
			FileReader file = new FileReader("products.txt");
			buff = new BufferedReader(file);
			 String line="";
	            while ((line = buff.readLine()) != null) {
	                 String [] pom = line.split("&");	
	                 try {
	        			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productsdb", "postgres", "postgres");
	        			 statement = connection.prepareStatement("INSERT INTO products (uniquekey,name,price,quantity) VALUES (?,?,?,?)");
	        			 statement.setString(1, pom[0]);
	        			 statement.setString(2, pom[1]);
	        			 statement.setInt(3, Integer.valueOf(pom[2]));
	        			 statement.setInt(4, Integer.valueOf(pom[3]) );	       		 
	        			 statement.executeUpdate();
	        			 System.out.println("Insert done!");       			 
	        		} catch(SQLException e){
	        			e.printStackTrace();
	        		} finally{
	        			try {
							connection.close();
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}	
	        		} 
	            }			
			}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	public ArrayList<Product> getDataFromStorage() {
		ArrayList<Product> products = new ArrayList<Product>();
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productsdb", "postgres", "postgres");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from products");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("uniquekey");
			    String name = resultSet.getString("name");
			    int price = resultSet.getInt("price");
			    int quantity = resultSet.getInt("quantity");
			    Product p = new Product(id,name,price,quantity);
			    products.add(p);
			}
			
			}catch (SQLException e) {
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
			return products;
		
	}
	
	public void showDataFromStorage() {

		ArrayList<Product> products = this.getDataFromStorage();
		for(Product p : products){
			System.out.println("Name: " + p.getProductName() + " Price: " + p.getProductPrice() + " Quantity: " + p.getProductQuantity());
		}
		
	}

}
