import java.sql.SQLException;
import java.util.Scanner;


public class LibraryTest {

	public static void main(String[] argv) throws SQLException{
		
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
					
	}
}
