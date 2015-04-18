package com.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
	
@Entity
@Table(name = "creditcard")
public class CreditCard {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "cardnumber", unique=true, nullable = false)
		private String cardNumber;
		
		@Column(name = "balance")
		private int balance;
		
		@Column(name = "exprirationdDate")
		private Date exprirationDate;
		
		@OneToMany(mappedBy = "creditcard" , fetch = FetchType.EAGER)
		private Set<UserAccount> userAcounts;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public Date getExprirationDate() {
			return exprirationDate;
		}

		public void setExprirationDate(Date exprirationDate) {
			this.exprirationDate = exprirationDate;
		}

		public Set<UserAccount> getUserAcounts() {
			return userAcounts;
		}

		public void setUserAcounts(Set<UserAccount> userAcounts) {
			this.userAcounts = userAcounts;
		}
		
		 @Override
		    public String toString() {
		        return "Credit card [id = " + id + ", card number = " + cardNumber + ", balance = "
		                + balance + ", expiration date = " + exprirationDate + "]";
		    }
		
	}
