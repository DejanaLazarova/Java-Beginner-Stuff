package EntityOperations;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import EntityClasses.*;
import Interfaces.*;

public class MemberOperations implements DatabaseOperations{

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

	public void update(Session session, String memberName, String newName,String newEmail) {
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			String hql = "UPDATE Member SET name = :newName, email = :newEmail WHERE name = :memberName";
			Query query = session.createQuery(hql);
			query.setParameter("newName", newName);
			query.setParameter("newEmail", newEmail);
			query.setParameter("name", memberName);
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

	public void delete(Session session, String memberName) {
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			String hql = "DELETE FROM Member WHERE name = :memberName";
			Query query = session.createQuery(hql);
			query.setParameter("name", memberName);
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
		Criteria cr = session.createCriteria(Member.class);
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
		return (ArrayList<Member>)results;
	}

	public <E> void Print(ArrayList<E> results) {
		ArrayList<Member> memberResults = (ArrayList<Member>)results;
		for(Member member : memberResults){
			System.out.println("Name " + member.getName() + " Email: " + member.getEmail());
		}
		
	}

}
