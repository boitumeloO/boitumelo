package com.acme.test01.boitumeloOliphant.boitumelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.test01.boitumeloOliphant.boitumelo.entities.Customer;
import com.acme.test01.boitumeloOliphant.exceptions.AccountNotFoundException;
import com.acme.test01.boitumeloOliphant.exceptions.WithdrawalAmountTooLargeException;

@RestController
public class AccountServiceImpl {

	@Autowired
	CustomerRepository repository;

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/withdraw/{acountId}/{amountToWithdraw}")
	public ResponseEntity<Void> withdraw(@PathVariable long accountId, @PathVariable int amountToWithdraw)
			throws AccountNotFoundException, WithdrawalAmountTooLargeException {
		System.out.println("withdrawing money");
		Customer cust = repository.findOne(accountId);
		if (cust != null) {
			cust.getAccount().withdraw(amountToWithdraw);
			repository.save(cust);
		} else {
			throw new AccountNotFoundException(String.format("Account %i not found ", accountId));
		}
		
		return ResponseEntity.noContent().build();
		
	}

	@PostMapping("/deposit/{acountId}/{amountToDeposit}")
	public void deposit(@PathVariable Long accountId, @PathVariable int amountToDeposit)
			throws AccountNotFoundException {
		Customer cust = repository.findOne(accountId);
		if (cust != null) {
			cust.getAccount().deposit(amountToDeposit);
			repository.save(cust);
		} else {
			throw new AccountNotFoundException(String.format("Account %i not found ", accountId));
		}
	}
}
