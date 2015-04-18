package com.templateclasses;

import java.util.List;

import org.hibernate.Session;

public abstract class ExecuteOperations {
	
	public void executeOperation(Session session){}

	public List executeOperation(Session session, List result){
		return result;
		
	}
}
