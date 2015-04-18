package testPackage;
import Interfaces.*;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import EntityClasses.Book;
import EntityClasses.Loan;
import EntityClasses.Magazine;
import EntityClasses.Member;
import EntityClasses.Membership;
import EntityClasses.Publication;

public class LibraryTemplateClass {

	public void templateMethod(DatabaseOperations db) {
		executeTask(db);
	}
	
	public void templateMethod(DatabaseOperationsReturn databaseOperationsReturn){
		returnTask(databaseOperationsReturn);
	}

	public void executeTask(DatabaseOperations databaseOperations) {

		Session session = openConnection();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			databaseOperations.executeOperation(session);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("rawtypes")
	public ArrayList returnTask(DatabaseOperationsReturn databaseOperationsReturn) {

		Session session = openConnection();
		Transaction tx = null;
		ArrayList result = null;
		try {
			tx = session.beginTransaction();
			result = databaseOperationsReturn.executeOperation(session);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}
		return result;
	}

	public Session openConnection() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Publication.class)
				.addAnnotatedClass(Member.class)
				.addAnnotatedClass(Membership.class)
				.addAnnotatedClass(Loan.class)
				.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}
}
