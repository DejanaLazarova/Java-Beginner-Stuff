package DaoImplementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import Interfaces.*;
import testPackage.*;
import EntityClasses.*;

public class MembershipDaoImplementation implements DaoOperations, ReturnDaoOperations {

	Membership membership;
	
	public MembershipDaoImplementation() {}

	public MembershipDaoImplementation(Membership membership) {
		this.membership = membership;
	}

	public void registerPublication() {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				session.save(membership);			
			}
		});	
	}

	public void updateRegistration() {
		// implementation not necessary right now
	}

	public void unregisterPublication() {
		// implementation not necessary right now
	}

	public <E> void Print(final ArrayList<E> results) {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				ArrayList<Membership> membershipResults = (ArrayList<Membership>)results;
				for(Membership membership : membershipResults){
					System.out.println("Member name : " + membership.getMember().getName() +  
									   " Member email: " + membership.getMember().getEmail() +
									   " Start date : " + membership.getStartDate() + 
									   " End date: " + membership.getEndDate() +
									   " Membership type: " + membership.getMembershiptype());
				}				
			}
		});
	}
	
	public ArrayList listItems() {
		
		return new LibraryTemplateClass().returnTask(new DatabaseOperationsReturn() {

			public ArrayList executeOperation(Session session) {
				Criteria cr = session.createCriteria(Membership.class);
				List results = cr.list();
				return (ArrayList) results;
			}
		});
	}

}
