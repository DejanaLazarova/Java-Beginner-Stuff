package com.dao;
import java.util.List;

import com.model.CreditCard;


public interface CreditCardDao {
	
	public void saveCreditCard(CreditCard card);
	
	public void removeCreditCard(String cardNumber);
	
	public List<CreditCard> getCreditCards();

}
