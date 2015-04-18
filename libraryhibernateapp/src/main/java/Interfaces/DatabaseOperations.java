package Interfaces;

import org.hibernate.Session;

public interface DatabaseOperations {
	
	public void executeOperation(Session session);
}
