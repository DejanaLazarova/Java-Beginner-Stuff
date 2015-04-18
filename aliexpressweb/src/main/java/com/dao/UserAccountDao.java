package com.dao;

import java.util.List;

import com.model.CreditCard;
import com.model.UserAccount;

public interface UserAccountDao {
	
	public void saveAccount(UserAccount userAccount);
	
	public void modifyAccount(String email, String newEmail, String newPassword);
	
	public void deleteAccount(String email);
	
	public void blockAccount(String email);
	
	public List<UserAccount> getUserAccounts();
	
	public void addCreditCard(CreditCard card);
	
	public List<UserAccount> getAccount(String email, String password);

}
