package com.acme.test01.boitumeloOliphant.boitumelo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.acme.test01.boitumeloOliphant.exceptions.WithdrawalAmountTooLargeException;

@Entity
@Table(name = "CurrentAccount")
public class CurrentAccount extends Account {
	private static final long serialVersionUID = 3963157662126349523L;
	private int id; 
	private int overDraft; 
	private int balance; 
	
	public CurrentAccount(int balance, int overDraft) {
		super(balance);
		this.overDraft = overDraft;
	}

	
	public CurrentAccount() {
	}
	
	@Id
	@Column(name = "account_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize=1)
	public int getId() {
		return id;
	}

	@Column(name = "over_draft")
	public int getOverDraft() {
		return overDraft;
	}

	@Column(name = "balance")
	public int getBalance() {
		return balance;
	}
	
	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}


	@Override
	public int withdraw(int amount) throws WithdrawalAmountTooLargeException {
		if ((getBalance() + getOverDraft() - amount) > 0) {
			setBalance(getBalance() - amount);
		} else {
			throw new WithdrawalAmountTooLargeException("Withdrawal limit exceeded ");
		}
		return getBalance();
	}


	public void setId(int id) {
		this.id = id;
	}

}
