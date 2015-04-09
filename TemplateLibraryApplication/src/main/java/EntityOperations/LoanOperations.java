package EntityOperations;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Interfaces.*;
import EntityClasses.*;

public class LoanOperations implements DatabaseOperations {

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

	public void update(Session session, String oldRegCode, String newRegCode,
			String title) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Session session, String regCode) {
		// TODO Auto-generated method stub
		
	}

	public <E> ArrayList List(Session session) {
		Criteria cr = session.createCriteria(Loan.class);
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
		return (ArrayList<Loan>)results;
	}


	public <E> void Print(ArrayList<E> results) {
		ArrayList<Loan> loanResults = (ArrayList<Loan>)results;
		for(Loan loan : loanResults){
			System.out.println("Start date : " + loan.getStartDate() +  
							   " End date : " + loan.getEndDate() +
							   " Member name : " + loan.getMember().getName() + 
							   " Member email: " + loan.getMember().getEmail() +
							   " Publication title : " + loan.getPublication().getTitle());
		}
		
	}

}
