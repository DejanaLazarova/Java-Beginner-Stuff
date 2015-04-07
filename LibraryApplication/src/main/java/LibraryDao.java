import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryDao {
	
	Connection connection = null;
	PreparedStatement statement = null;
	
	public void registerBook(Book book) throws SQLException
	{
		try {
			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			 statement = connection.prepareStatement("INSERT INTO book (isbn,title) VALUES (?,?)");
			 statement.setString(1, book.getIsbn());
			 statement.setString(2, book.getTitle());
			 statement.executeUpdate();
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
		Statement statement = connection.createStatement();
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
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			 statement = connection.prepareStatement("UPDATE book SET title = ? WHERE isbn = ?");
			 statement.setString(1, book.getTitle());
			 statement.setString(2, book.getIsbn());
			 statement.executeUpdate();
			 System.out.println("Update done!");
	
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				statement.close();
				connection.close();
			}
		}

	public void unregisterBook(String isbn) throws SQLException {
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			 statement = connection.prepareStatement("DELETE FROM book WHERE isbn = ?");
			 statement.setString(1, isbn);
			 statement.executeUpdate();
			 System.out.println("Unregistered!");
	
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				statement.close();
				connection.close();
			}
		
	}
}
