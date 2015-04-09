import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import EntityClasses.*;
import Interfaces.*;

public class LibraryTemplate {
	
	DatabaseOperations operation;
	
	public LibraryTemplate(DatabaseOperations operation){
		this.operation = operation;
	}

	public void RegisterEntity(Object object){
		Session session = openConnection();
		operation.register(session,object);
	}
	
	public void updateRegistrations(String oldRegCode, String newRegCode, String title){
		Session session = openConnection();
		operation.update(session,oldRegCode,newRegCode,title);
	}
	
	public void deleteRegistration(String regCode){
		Session session = openConnection();
		operation.delete(session, regCode);
	}	
	
	@SuppressWarnings("unchecked")
	public void ListEntity(){
		Session session = openConnection();
		@SuppressWarnings("rawtypes")
		ArrayList results = operation.List(session);
		operation.Print(results);
	}
	
	public Session openConnection()
	{
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
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
