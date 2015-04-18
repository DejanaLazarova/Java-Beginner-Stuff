package com.templateclasses;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.*;


public class AliExpressTemplateClass {
	
	public void templateMethod(ExecuteOperations eo) {
		executeTask(eo);
		returnTask(eo);
	}
	

	public void executeTask(ExecuteOperations executeOperations) {

		Session session = openConnection();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			executeOperations.executeOperation(session);
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
	public List returnTask(ExecuteOperations executeOperations) {

		Session session = openConnection();
		Transaction tx = null;
		List result = null;
		try {
			tx = session.beginTransaction();
			result = executeOperations.executeOperation(session, result);
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
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(UserAccount.class)
				.addAnnotatedClass(CreditCard.class)
				.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}
	

}
