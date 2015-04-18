package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Repository;

import com.model.CreditCard;
import com.model.Product;
import com.model.UserAccount;
import com.templateclasses.AliExpressTemplateClass;
import com.templateclasses.ExecuteOperations;
import com.templateclasses.ExecuteReturnOperations;

@Repository("accountDao")
public class UserAccountDaoImplementation implements UserAccountDao{

	@Override
	public void saveAccount(final UserAccount userAccount) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				session.save(userAccount);
			}
		});
	}

	@Override
	public void modifyAccount(final String email, final String newEmail,final String newPassword) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				Query query = session.createQuery("UPDATE useraccount SET email = :newEmail, password = :newPassword WHERE email = :email");
				query.setParameter("email", email);
				query.setParameter("newEmail", newEmail);
				query.setParameter("newPassword", newPassword);
				query.executeUpdate();
			}
		});	
		
		
	}

	@Override
	public void deleteAccount(final String email) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				Query query = session.createQuery("DELETE FROM useraccount WHERE email = :email");
				query.setParameter("email", email);
				query.executeUpdate();
			}
		});
	}

	@Override
	public void blockAccount(String email) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getUserAccounts() {
		return new AliExpressTemplateClass()
		.returnTask(new ExecuteOperations() {
			@Override
			public List executeOperation(Session session, List result) {
				Criteria cr = session.createCriteria(UserAccount.class);
			    result = cr.list();
				return (List<Product>)result;
			}
		});	}

	@Override
	public void addCreditCard(final CreditCard card) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				session.save(card);
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccount> getAccount(String email, String password) {
		return new AliExpressTemplateClass()
		.returnTask(new ExecuteOperations() {
			@Override
			public List executeOperation(Session session, List result) {
				Criteria cr = session.createCriteria(UserAccount.class);
			    result = cr.list();
				return (List<UserAccount>)result;
			}
		});
	}

}
