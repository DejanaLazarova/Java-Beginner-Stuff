package Interfaces;
import java.util.ArrayList;

public interface DaoOperations {
	
	public void registerPublication();
	public void updateRegistration();
	public void unregisterPublication();
	public <E> void Print(ArrayList<E> results);
}
