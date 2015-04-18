package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CreditCardDaoImplementation;
import com.model.CreditCard;

@Service
public class CreditCardServiceImplementation implements CreditCardService {
	
	private CreditCardDaoImplementation creditDao;
	
	@Autowired
	public CreditCardServiceImplementation(CreditCardDaoImplementation creditDao) {
		this.creditDao = creditDao;
	}

	@Override
	public void saveCreditCard(CreditCard card) {
		creditDao.saveCreditCard(card);
		
	}

	@Override
	public void removeCreditCard(String cardNumber) {
		creditDao.removeCreditCard(cardNumber);
		
	}

	@Override
	public List<CreditCard> getCreditCards() {
		return creditDao.getCreditCards();
	}

}
