package com.service;

import java.util.List;

import com.model.CreditCard;

public interface CreditCardService {
	
	public void saveCreditCard(CreditCard card);

	public void removeCreditCard(String cardNumber);

	public List<CreditCard> getCreditCards();
}
