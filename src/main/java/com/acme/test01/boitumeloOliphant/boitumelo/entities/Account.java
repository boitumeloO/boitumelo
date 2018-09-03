package com.acme.test01.boitumeloOliphant.boitumelo.entities;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.acme.test01.boitumeloOliphant.exceptions.WithdrawalAmountTooLargeException;

public abstract class Account implements Serializable{
	private static final long serialVersionUID = 593512050969022412L;
	private int balance; 
//	private Customer customer; 
	
	public Account(int balance) {
		super();
		this.balance = balance;
//		this.customer = customer;
	}

	public Account() {
	}

	
	@Column(name = "balance")
	public int getBalance() {
		return balance;
	}
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "customer_id")
//	public Customer getCustomer() {
//		return customer;
//	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
	@Transient
	public abstract int withdraw(int amount) throws WithdrawalAmountTooLargeException;
	
	@Transient
	public void deposit(int amount) {
		setBalance(amount+ getBalance());
	}
}
