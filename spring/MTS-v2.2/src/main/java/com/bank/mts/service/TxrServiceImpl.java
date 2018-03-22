package com.bank.mts.service;

import com.bank.mts.model.Account;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.JdbcAccountRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public boolean txr(double amount, String fromAccNum, String toAccNum) {

		// load from & to accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);
		// debit & credit
		// update both accounts
		accountRepository.updateAcount(fromAccount);
		accountRepository.updateAcount(toAccount);
		return true;
	}

}
