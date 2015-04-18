package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserAccountDaoImplementation;
import com.model.CreditCard;
import com.model.UserAccount;

@Service
public class AccountServiceImplementation implements AccountService {

	private UserAccountDaoImplementation accountDao;
	
	@Autowired
	public AccountServiceImplementation(UserAccountDaoImplementation accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void registerAccount(UserAccount userAccount) {
		accountDao.saveAccount(userAccount);
		
	}

	@Override
	public void editAccount(String email, String newEmail, String newPassword) {
		accountDao.modifyAccount(email, newEmail, newPassword);
		
	}

	@Override
	public void deleteAccount(String email) {
		accountDao.deleteAccount(email);
		
	}

	@Override
	public void blockAccount(String email) {
		accountDao.blockAccount(email);
	}

	@Override
	public List<UserAccount> getUserAccounts() {
		return accountDao.getUserAccounts();
	}

	@Override
	public void addCreditCard(CreditCard card) {
		accountDao.addCreditCard(card);
		
	}

	@Override
	public List checkAccount(String email, String password) {
		return accountDao.getAccount(email, password);
	}

}
