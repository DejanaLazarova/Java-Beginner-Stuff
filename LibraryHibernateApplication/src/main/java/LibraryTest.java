import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class LibraryTest {

	public static void main(String[] argv) throws SQLException{
		/*
		Scanner scanner = new Scanner(System.in);
		LibraryService libServ = new LibraryService();
		System.out.println("Registering a book, enter title and isbn");
		String title = scanner.nextLine();
		String isbn = scanner.nextLine();
		Book b = new Book(title,isbn);
		libServ.register(b);
		System.out.println("Listing registered books");
		libServ.ListRegistered();
		System.out.println("Updating book registrations");
		System.out.println("Enter book isbn to update");
		isbn = scanner.nextLine();
		title = scanner.nextLine();
		b = new Book(title,isbn);
		libServ.UpdateRegistered(b);
	    */		
		
		Scanner scanner = new Scanner(System.in);
		LibraryHibernateService libServ = new LibraryHibernateService();
		System.out.println("Registering a book, enter title and isbn");
		String title = scanner.nextLine();
		String isbn = scanner.nextLine();
		BookDao b = new BookDao();
		b.setIsbn(isbn);
		b.setTitle(title);
		libServ.registerBook(b);
		System.out.println("Listing registered books");
		
		ArrayList<BookDao> books = libServ.listRegisteredBooks();
		
		for(int i = 0; i < books.size(); i++)
		{
			System.out.println( "Title: " + books.get(i).getIsbn() + "Name:" + books.get(i).getTitle());
		}
		
		System.out.println("Updating book registrations");
		System.out.println("Enter book isbn to update");
		isbn = scanner.nextLine();
		System.out.println("Enter title to update");
		title = scanner.nextLine();
		b = new BookDao();
		b.setIsbn(isbn);
		b.setTitle(title);
		libServ.UpdateRegisteredBooks(b);
		
		

	}
}
