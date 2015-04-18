package DaoImplementations;
import Interfaces.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import EntityClasses.Book;
import testPackage.*;

public class BookDaoImplementation implements DaoOperations, ReturnDaoOperations {

	Book book;

	public BookDaoImplementation(){}
	public BookDaoImplementation(Book book) {
		this.book = book;
	}

	public void registerPublication() {

		new LibraryTemplateClass().executeTask(new DatabaseOperations() {

			public void executeOperation(Session session) {
				session.save(book);
			}
		});
	}

	public void updateRegistration() {

		new LibraryTemplateClass().executeTask(new DatabaseOperations() {

			public void executeOperation(Session session) {
				String hql = "UPDATE Book SET title = :title WHERE isbn = :isbn";
				Query query = session.createQuery(hql);
				query.setParameter("title", book.getTitle());
				query.setParameter("isbn", book.getIsbn());
				query.executeUpdate();
			}
		});
	}

	public void unregisterPublication() {

		new LibraryTemplateClass().executeTask(new DatabaseOperations() {

			public void executeOperation(Session session) {
				String hql = "DELETE FROM Book WHERE isbn = :isbn";
				Query query = session.createQuery(hql);
				query.setParameter("isbn", book.getIsbn());
				query.executeUpdate();
			}
		});
	}

	public <E> void Print(final ArrayList<E> results) {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				ArrayList<Book> Bookresults = (ArrayList<Book>)results;
				for(Book book : Bookresults){
					System.out.println("Isbn: " + book.getIsbn() + " Title: " + book.getTitle());
				}			
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public ArrayList listItems() {

		return new LibraryTemplateClass().returnTask(new DatabaseOperationsReturn() {

					public ArrayList executeOperation(Session session) {
						Criteria cr = session.createCriteria(Book.class);
						List results = cr.list();
						return (ArrayList) results;
					}
				});
	}
}
