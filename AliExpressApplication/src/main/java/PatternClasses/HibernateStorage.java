package PatternClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import EntityClasses.Product;
import interfaces.StorageImplementation;

public class HibernateStorage implements StorageImplementation {

	BufferedReader buff;
	
	public void persistDataInStorage() {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Product.class).buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			FileReader file = new FileReader("products.txt");
			buff = new BufferedReader(file);
			 String line="";
	            while ((line = buff.readLine()) != null) {
	                 String [] pom = line.split("&");
	                 Product product = new Product();
	                 product.setId(Integer.valueOf(pom[0]));
	                 product.setProductName(pom[1]);
	                 product.setProductPrice(Integer.valueOf(pom[2]));
	                 product.setProductQuantity(Integer.valueOf(pom[3]));
	                 try {
	         			tx = session.beginTransaction();
	         			session.save(product);			
	         		    tx.commit();
	         		} catch (RuntimeException e) {
	         		    if (tx != null) { tx.rollback(); }
	         		    throw(e);
	         		} finally {
	         		    
	         		}  	                        
	            }			
			}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}

	public ArrayList<Product> getDataFromStorage() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Product.class).buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Product.class);
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
		return (ArrayList<Product>)results;
	}


	public void showDataFromStorage() {
		ArrayList<Product> results = this.getDataFromStorage();
		for(Product p : results){
			System.out.println("Name: " + p.getProductName() + " Price: " + p.getProductPrice() + " Quantity: " + p.getProductQuantity());
		}
		
	}
}
