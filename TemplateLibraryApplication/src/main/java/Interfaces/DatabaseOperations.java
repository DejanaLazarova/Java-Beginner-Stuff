package Interfaces;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public interface DatabaseOperations {
	
	public void register(Session session, Object object);
	
	public void update(Session session, String oldRegCode, String newRegCode, String title);
	
	public void delete(Session session, String regCode);
	
	public <E> ArrayList List(Session session);
	
	public <E> void Print(ArrayList <E> results); 
}
