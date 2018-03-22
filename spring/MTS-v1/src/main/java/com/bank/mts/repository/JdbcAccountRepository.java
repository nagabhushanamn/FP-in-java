package com.bank.mts.repository;

import com.bank.mts.model.Account;

public class JdbcAccountRepository implements AccountRepository {

	public Account loadAccount(String num) {
		// load account from DB
		Account account = new Account();
		account.setNum(num);
		account.setBalance(1000.00);
		return account;
	}

	public boolean updateAcount(Account account) {
		// TODO
		return true;
	}

}
