package EntityOperations;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import EntityClasses.*;
import Interfaces.*;

public class MagazineOperations implements DatabaseOperations  {

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
			String hql = "UPDATE Magazine SET issn = :issn, title = :title WHERE issn = :issn";
			Query query = session.createQuery(hql);
			query.setParameter("issn", newRegCode);
			query.setParameter("title", title);
			query.setParameter("issn", oldRegCode);
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
			String hql = "DELETE FROM Magazine WHERE issn = :issn";
			Query query = session.createQuery(hql);
			query.setParameter("issn", regCode);
			query.executeUpdate();			
		    tx.commit();

		} catch (RuntimeException e) {
		    if (tx != null) { tx.rollback(); }
		    	throw(e);
		} finally {
		    session.close();
		}
		
	}

	public <E> ArrayList List(Session session) {
		Criteria cr = session.createCriteria(Magazine.class);
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
		return (ArrayList<Magazine>)results;
	}

	public <E> void Print(ArrayList<E> results) {
			ArrayList<Magazine> magazineResults = (ArrayList<Magazine>)results;
			for(Magazine magazine : magazineResults){
				System.out.println("Issn: " + magazine.getIssn() + " Title: " + magazine.getTitle());
			}
			
		}
		
	}