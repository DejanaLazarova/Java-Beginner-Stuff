package DaoImplementations;
import Interfaces.*;

import java.util.ArrayList;
import java.util.List;

import EntityClasses.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import testPackage.*;

public class MagazineDaoImplementation implements DaoOperations, ReturnDaoOperations{

	Magazine magazine;
	
	public MagazineDaoImplementation(){}
	
	public MagazineDaoImplementation(Magazine magazine) {
		this.magazine = magazine;
	}
	public void registerPublication() {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				session.save(magazine);				
			}
		});
	}
	public void updateRegistration() {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				String hql = "UPDATE Book SET title = :title WHERE issn = :issn";
				Query query = session.createQuery(hql);
				query.setParameter("title", magazine.getTitle());
				query.setParameter("issn", magazine.getIssn());
				query.executeUpdate();			
			}
		});
	}

	public void unregisterPublication() {
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				String hql = "DELETE FROM Magazine WHERE issn = :issn";
				Query query = session.createQuery(hql);
				query.setParameter("issn", magazine.getIssn());
				query.executeUpdate();							
			}
		});
	}
	
	public <E> void Print(final ArrayList<E> results) {

		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				ArrayList<Magazine> magazineResults = (ArrayList<Magazine>)results;
				for(Magazine magazine : magazineResults){
					System.out.println("Issn: " + magazine.getIssn() + " Title: " + magazine.getTitle());
				}			
			}
		});
		
	}
	public ArrayList listItems() {

		return new LibraryTemplateClass().returnTask(new DatabaseOperationsReturn() {

			public ArrayList executeOperation(Session session) {
				Criteria cr = session.createCriteria(Magazine.class);
				List results = cr.list();
				return (ArrayList) results;
			}
		});
	}
}
