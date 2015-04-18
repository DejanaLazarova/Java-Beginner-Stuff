package DaoImplementations;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import testPackage.LibraryTemplateClass;
import EntityClasses.*;
import Interfaces.*;

public class LoanDaoimplementation implements DaoOperations, ReturnDaoOperations {

	Loan loan;
	
	public LoanDaoimplementation(){}
	
	public LoanDaoimplementation(Loan loan) {
		super();
		this.loan = loan;
	}
	
	public void registerPublication() {
		new LibraryTemplateClass().executeTask(new DatabaseOperations() {
			
			public void executeOperation(Session session) {
				session.save(loan);			
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
				ArrayList<Loan> loanResults = (ArrayList<Loan>)results;
				for(Loan loan : loanResults){
					System.out.println("Start date : " + loan.getStartDate() +  
									   " End date : " + loan.getEndDate() +
									   " Member name : " + loan.getMember().getName() + 
									   " Member email: " + loan.getMember().getEmail() +
									   " Publication title : " + loan.getPublication().getTitle());
				}	
			}
		});
		
	}

	public ArrayList listItems() {
		
		return new LibraryTemplateClass().returnTask(new DatabaseOperationsReturn() {

			public ArrayList executeOperation(Session session) {
				Criteria cr = session.createCriteria(Loan.class);
				List results = cr.list();
				return (ArrayList) results;
			}
		});
	}
}
