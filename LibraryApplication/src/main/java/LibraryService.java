import java.sql.SQLException;
import java.util.ArrayList;


public class LibraryService {
	
	ArrayList<Book> books;
	LibraryDao libDao;
	
	public LibraryService()
	{
		books = new ArrayList<Book>();
		libDao = new LibraryDao();
	}
	
	public void register(Book book) throws SQLException
	{ 
		libDao.registerBook(book);
	}
	
	public void ListRegistered() throws SQLException
	{
		libDao.listRegisteredBooks();
	}
	
	public void UpdateRegistered(Book book) throws SQLException
	{
		libDao.UpdateRegisteredBooks(book);
	}

}
