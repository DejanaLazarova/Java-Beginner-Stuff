import java.util.ArrayList;
import java.util.List;


public interface LibrayHibernateOperations {
	

	public void registerBook(BookDao book);
	
	public ArrayList<BookDao> listRegisteredBooks();
	
	public void UpdateRegisteredBooks(BookDao book);
	
	public void deleteRegisteredBook(BookDao book);

}
