package com.acme.test01.boitumeloOliphant.boitumelo;

import com.acme.test01.boitumeloOliphant.exceptions.AccountNotFoundException;
import com.acme.test01.boitumeloOliphant.exceptions.WithdrawalAmountTooLargeException;

public interface AccountService {
	public void openSavingsAccount(Long accountId, Long amountToDeposit);

	public void openCurrentAccount(Long accountId);

	public void withdraw(Long accountId, int amountToWithdraw)
			throws AccountNotFoundException, WithdrawalAmountTooLargeException;

	public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException;
}