package Interfaces;
import java.util.ArrayList;
import org.hibernate.Session;

public interface DatabaseOperationsReturn {
	public ArrayList executeOperation(Session session);
}
