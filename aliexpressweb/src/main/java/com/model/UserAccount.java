package com.model;

import javax.persistence.*;

@Entity
@Table(name = "useraccount")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "state")
	private String state;
	@ManyToOne
	private CreditCard creditcard;
	
	public CreditCard getCreditCard() {
		return creditcard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditcard = creditCard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	 @Override
	    public String toString() {
	        return "User account [ id= " + id + ", user name =" + name + ", surname = "
	                + surname + ", email = " + email + ", address = " + address + ", state" +  state + "]";
	    }
}