package EntityOperations;
import EntityClasses.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Interfaces.*;

import java.util.*;

public class BookOperations implements DatabaseOperations  {

	public void register(Session session, Object object) {
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(object);			
		    tx.commit();
		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    throw(e);

		} finally {
		    session.close();
		}
	}

	public void update(Session session, String oldRegCode, String newRegCode, String title) {
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			String hql = "UPDATE Book SET isbn = :isbn, title = :title WHERE isbn = :oldisbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", newRegCode);
			query.setParameter("title", title);
			query.setParameter("oldisbn", oldRegCode);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);		
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);
		} finally {
		    session.close();
		}		
	}

	public void delete(Session session, String regCode) {
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			String hql = "DELETE FROM Book WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", regCode);
			query.executeUpdate();			
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);
		} finally {
		    session.close();
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> ArrayList List(Session session) {
		Criteria cr = session.createCriteria(Book.class);
		Transaction tx = null;
		List results=null;
		try {
			
			tx = session.beginTransaction();
			results = cr.list();
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);

		} finally {
		    session.close();
		}	
		return (ArrayList<Book>)results;
	}

	public <E> void Print(ArrayList<E> results) {
		ArrayList<Book> Bookresults = (ArrayList<Book>)results;
		for(Book book : Bookresults){
			System.out.println("Isbn: " + book.getIsbn() + " Title: " + book.getTitle());
		}
		
	}
}
	


