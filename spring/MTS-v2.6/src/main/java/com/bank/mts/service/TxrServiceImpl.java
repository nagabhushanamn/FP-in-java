package com.bank.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mts.model.Account;
import com.bank.mts.repository.AccountRepository;

@Component("txrService")
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	@Autowired
	@Qualifier("jpaAccountRepository")
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public boolean txr(double amount, String fromAccNum, String toAccNum) {
		// load from & to accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		System.out.println(fromAccount);
		System.out.println(toAccount);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		// update both accounts
		accountRepository.updateAcount(fromAccount);
		accountRepository.updateAcount(toAccount);
		return true;
	}

}
