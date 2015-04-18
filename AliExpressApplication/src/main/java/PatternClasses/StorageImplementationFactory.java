package PatternClasses;

import interfaces.StorageImplementation;

public abstract class StorageImplementationFactory {

	public static final int INMEMORY = 1;
	public static final int JDBC = 2;
	public static final int HIBERNATE = 3;

	public static StorageImplementation makeStorage(int storage){
		  
		switch (storage) {
		case INMEMORY:
			return new InMemoryStorage();
		case JDBC:
			return new JDBCStorage();
		case HIBERNATE:
			return new HibernateStorage();
		default:
			return null;
		}
	}
}
