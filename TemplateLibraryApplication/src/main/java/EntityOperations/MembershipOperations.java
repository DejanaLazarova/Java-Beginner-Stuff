package EntityOperations;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.translation.messages_bg;

import EntityClasses.*;
import Interfaces.*;

public class MembershipOperations implements DatabaseOperations
{

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
		
	}

	public void delete(Session session, String regCode) {
		// TODO Auto-generated method stub
		
	}

	public <E> ArrayList List(Session session) {
		Criteria cr = session.createCriteria(Membership.class);
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
		return (ArrayList<Membership>)results;
	}

	public <E> void Print(ArrayList<E> results) {
		ArrayList<Membership> membershipResults = (ArrayList<Membership>)results;
		for(Membership membership : membershipResults){
			System.out.println("Member name : " + membership.getMember().getName() +  
							   " Member email: " + membership.getMember().getEmail() +
							   " Start date : " + membership.getStartDate() + 
							   " End date: " + membership.getEndDate() +
							   " Membership type: " + membership.getMembershiptype());
		}
		
	}

}
