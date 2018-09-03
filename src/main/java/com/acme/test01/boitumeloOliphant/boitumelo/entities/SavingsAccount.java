package com.acme.test01.boitumeloOliphant.boitumelo.entities;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.acme.test01.boitumeloOliphant.exceptions.WithdrawalAmountTooLargeException;

@Entity
@Table(name = "SavingsAccount")
public class SavingsAccount extends Account {
	public static int MINIMUM_BALANCE = 1000;
	private int id; 
	private int balance; 

	public SavingsAccount() {
	}
	
	public SavingsAccount( int balance) {
		super(balance );
	}

	@Id
	@Column(name = "account_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	@Transient
	public int withdraw(int amount) throws WithdrawalAmountTooLargeException{
		if ((getBalance() - amount) > MINIMUM_BALANCE) {
			setBalance(getBalance() - amount);
		} else {
			throw new WithdrawalAmountTooLargeException("Saving account cannot have a balance of less then " + MINIMUM_BALANCE);
		}
		return getBalance();
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "balance")
	public int getBalance() {
		return balance;
	}
}
