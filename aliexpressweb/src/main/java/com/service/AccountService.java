package com.service;

import java.util.List;

import com.model.CreditCard;
import com.model.UserAccount;

public interface AccountService {
	
	public void registerAccount(UserAccount userAccount);
	
	public void editAccount(String email, String newEmail, String newPassword);
	
	public void deleteAccount(String email);
	
	public void blockAccount(String email);
	
	public List<UserAccount> getUserAccounts();
	
	public void addCreditCard(CreditCard card);
	
	public List checkAccount(String email, String password);
}
