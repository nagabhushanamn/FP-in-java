package com.bank.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bank.mts.model.Account;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.JdbcAccountRepository;

@Component("txrService")
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	@Autowired
	@Qualifier("jdbcAccountRepository")
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
