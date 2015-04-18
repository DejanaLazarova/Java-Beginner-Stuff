package com.templateclasses;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public interface ExecuteReturnOperations {
	public List executeOperation(Session session);
}
