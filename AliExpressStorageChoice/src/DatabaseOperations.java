import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseOperations implements ShowProducts {

	Connection connection = null;
	Statement statement = null;
	
	@Override
	public void showProducts() {
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productsdb", "postgres", "postgres");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from products");
			
			while (resultSet.next()) {
			    String name = resultSet.getString("name");
			    int price = resultSet.getInt("price");
			    int quantity = resultSet.getInt("quantity");
			    System.out.println(name + " | " + price + " | " + quantity);
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
	}

	@Override
	public int getPriceByProductName(String product) {
		int price = 0;
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productsdb", "postgres", "postgres");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from products WHERE name = '" + product + "'");
			
			while (resultSet.next()) {
			    price = resultSet.getInt("price");
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
		return price;
	}

}
