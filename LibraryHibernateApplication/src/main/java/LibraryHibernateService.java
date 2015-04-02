
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class LibraryHibernateService implements LibrayHibernateOperations {
	
	
	public SessionFactory connect()
	{
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(BookDao.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public void registerBook(BookDao book) {
		
		Session session = connect().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);			
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    throw(e);

		} finally {
		    session.close();
		}

		connect().close();
	}

	public ArrayList<BookDao> listRegisteredBooks() {
		
		Session session = connect().openSession();
		Criteria cr = session.createCriteria(BookDao.class);
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
		
		connect().close();	
		return (ArrayList<BookDao>)results;
	}

	public void UpdateRegisteredBooks(BookDao book) {

		Session session = connect().openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();

			String hql = "UPDATE BookDao set title = :title WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", book.getTitle());
			query.setParameter("isbn", book.getIsbn());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);

		} finally {
		    session.close();
		}
		connect().close();		
	}

	public void deleteRegisteredBook(BookDao book) {

		Session session = connect().openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();

			String hql = "DELETE FROM BookDao WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", book.getIsbn());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);

		} finally {
		    session.close();
		}
		connect().close();
		
	}

}
