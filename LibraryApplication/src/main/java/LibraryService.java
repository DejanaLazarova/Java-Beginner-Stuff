import java.sql.SQLException;

public class LibraryService {
	
	LibraryDao libDao;
	
	public LibraryService()
	{
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
	
	public void UnregisterBook(String isbn) throws SQLException
	{
		libDao.unregisterBook(isbn);
	}

}
