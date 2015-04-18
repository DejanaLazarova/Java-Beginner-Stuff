package DaoImplementations;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import Interfaces.*;
import testPackage.*;
import EntityClasses.*;


public class MemberDaoImplementation implements DaoOperations, ReturnDaoOperations  {

	Member member;
	
	public MemberDaoImplementation(){}
	
	public MemberDaoImplementation(Member member){
		this.member = member;
	}
	
	public void registerPublication() {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				session.save(member);			
			}
		});	
	}

	public void updateRegistration() {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				String hql = "UPDATE Member SET name = :newName, email = :newEmail WHERE name = :memberName";
				Query query = session.createQuery(hql);
				query.setParameter("newName", member.getName());
				query.setParameter("newEmail", member.getEmail());
				query.setParameter("name", member.getName());
				query.executeUpdate();				
			}
		});
		
	}

	public void unregisterPublication() {

		new LibraryTemplateClass().executeTask(new DatabaseOperations() {

			public void executeOperation(Session session) {
				String hql = "DELETE FROM Member WHERE name = :memberName";
				Query query = session.createQuery(hql);
				query.setParameter("name", member.getName());
				query.executeUpdate();			
			}		
		});		
	}

	public <E> void Print(final ArrayList<E> results) {
		
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				ArrayList<Member> memberResults = (ArrayList<Member>)results;
				for(Member member : memberResults){
					System.out.println("Name " + member.getName() + " Email: " + member.getEmail());
				}		
			}
		});
	}
	

	public ArrayList listItems() {
		
		return new LibraryTemplateClass().returnTask(new DatabaseOperationsReturn() {

			public ArrayList executeOperation(Session session) {
				Criteria cr = session.createCriteria(Member.class);
				List results = cr.list();
				return (ArrayList) results;
			}
		});
	}

}
