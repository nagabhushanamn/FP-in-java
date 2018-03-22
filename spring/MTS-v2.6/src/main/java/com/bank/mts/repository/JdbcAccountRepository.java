package com.bank.mts.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.mts.model.Account;

@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {
	
	@Autowired
	private DataSource dataSource;

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
