package com.acme.test01.boitumeloOliphant.boitumelo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1552973734470106227L;
	private int customerId; 
	private String customerNumber; 
	private String name;
	private String surname;
	private String address;
	private SavingsAccount savingAccount;
	private CurrentAccount curAccount;
	
	public Customer() {
	}
	
	public Customer(String customerNumber, String name, String surname, String address) {
		super();
		this.customerNumber = customerNumber;
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	public Customer(String customerNumber, String name, String surname, String address, SavingsAccount savingAccount,
			CurrentAccount curAccount) {
		super();
		this.customerNumber = customerNumber;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.savingAccount = savingAccount;
		this.curAccount = curAccount;
	}

	@Id
	@Column(name = "customer_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_seq")
    @SequenceGenerator(name = "Customer_seq", sequenceName = "Customer_seq", allocationSize=1)
	public int getCustomerId() {
		return customerId;
	}

	@Column(name = "customer_number", unique = true, nullable = false)
	public String getCustomerNumber() {
		return customerNumber;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Transient
	public Account getAccount() {
		if (getCurAccount() != null) {
			return getCurAccount();
		}else {
			return getSavingAccount();
		}
	}

	

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "curent_account_id")
	public CurrentAccount getCurAccount() {
		return curAccount;
	}

	public void setCurAccount(CurrentAccount curAccount) {
		this.curAccount = curAccount;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "saving_account_id")
	public SavingsAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingsAccount savingaccount) {
		this.savingAccount = savingaccount;
	}

}
