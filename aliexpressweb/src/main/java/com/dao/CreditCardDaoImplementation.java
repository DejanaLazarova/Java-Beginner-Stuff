package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.model.CreditCard;
import com.model.Product;
import com.templateclasses.*;

@Repository("creditCardDao")
public class CreditCardDaoImplementation implements CreditCardDao{

	@Override
	public void saveCreditCard(final CreditCard card) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				session.save(card);
			}
		});
	}

	@Override
	public void removeCreditCard(final String cardNumber) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				Query query = session.createQuery("DELETE FROM creditcard WHERE cardNumber = :cardNumber");
				query.setParameter("cardNumber", cardNumber);
				query.executeUpdate();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditCard> getCreditCards() {
		return new AliExpressTemplateClass()
		.returnTask(new ExecuteOperations() {
			@Override
			public List executeOperation(Session session, List result) {
				Criteria cr = session.createCriteria(CreditCard.class);
			    result = cr.list();
				return (List<CreditCard>)result;
			}
		});
	}

}
