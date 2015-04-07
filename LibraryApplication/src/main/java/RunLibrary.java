import java.sql.SQLException;
import java.util.Scanner;


public class RunLibrary {

	Scanner scanner = new Scanner(System.in);
	LibraryService libraryService = new LibraryService();
	Book book;
	
	public void run() throws SQLException
	{
		printMenu();
		boolean end = false;
		while(!end)
		{			
			String action = scanner.next();
			if(action.equals("1")) 
			{
				System.out.println("Registering a book, enter isbn:");				
				String isbn = scanner.next();
				scanner.nextLine();
				System.out.println("Book title:");
				String title = scanner.nextLine();
				book = new Book(title,isbn);
				libraryService.register(book);
				end = false;
			}
			else if (action.equals("2"))
			{
				System.out.println("Listing registered books");
				libraryService.ListRegistered();
				end = false;
			}
			else if (action.equals("3"))
			{		
				System.out.println("Updating book registrations");
				System.out.println("Enter the book isbn you wish to update");
				String isbn = scanner.next();
				scanner.nextLine();
				System.out.println("Enter new title");
				String title = scanner.nextLine();
				book = new Book(title,isbn);
				libraryService.UpdateRegistered(book);
				end = false;
			}
			else if(action.equals("4"))
			{
				System.out.println("Enter the book isbn you wish to unregister");
				String isbn = scanner.next();
				libraryService.UnregisterBook(isbn);
				end = false;
			}			
			else if(action.equals("end"))
			{
				end = true;
				System.out.println("BYE.");
				break;
			}
		}
	}
	public void printMenu(){
		System.out.println("Please choose an action from the list below:");
		System.out.println("Enter 1 to register a book");
		System.out.println("Enter 2 to list registered books");
		System.out.println("Enter 3 to update book registrations");
		System.out.println("Enter 4 to unregister a book");
		System.out.println("Enter end to exit");
	}
}
