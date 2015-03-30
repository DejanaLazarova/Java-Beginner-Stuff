import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class LibraryDao {
	
	Connection connection = null;
	Statement statement = null;
	
	public void registerBook(Book book) throws SQLException
	{
		String query = "INSERT INTO book(title,isbn) VALUES ('" + book.getTitle() + "' , '" + book.getIsbn() +  "')";
		try {
			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			 statement = connection.createStatement();
			 statement.executeUpdate(query);
			 System.out.println("Insert done!");
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			statement.close();
			connection.close();
		}
	}
	
	public void listRegisteredBooks() throws SQLException
	{
	try{
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from book");
		
		while (resultSet.next()) {
		    int id = resultSet.getInt("id");
		    String isbn = resultSet.getString("isbn");
		    String title = resultSet.getString("title");
		    System.out.println(id + " | " + isbn + " | " + title);
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			statement.close();
			connection.close();
		}
	}
	
	public void UpdateRegisteredBooks(Book book) throws SQLException
	{
	String query = "UPDATE book SET title = '" + book.getTitle() + "' , isbn = '" + book.getIsbn() +  "' WHERE isbn = '" + book.getIsbn() + "'";
	try{
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
		statement = connection.createStatement();
		 statement.executeUpdate(query);
		 System.out.println("Update done!");

		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			statement.close();
			connection.close();
		}
	}
}
