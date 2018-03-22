package com.bank.mts;

import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.HibernateAccountRepository;
import com.bank.mts.repository.JdbcAccountRepository;
import com.bank.mts.service.TxrService;
import com.bank.mts.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// Init
		// ---------------------------------------------------
		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
		AccountRepository hibAccountRepository = new HibernateAccountRepository();
		TxrServiceImpl txrService = new TxrServiceImpl();
		txrService.setAccountRepository(hibAccountRepository);
		// ---------------------------------------------------

		// Use
		// ---------------------------------------------------
		boolean confirm = txrService.txr(1000.00, "1", "2");
		System.out.println(confirm ? "Txr success" : "Txr failed");
		// ---------------------------------------------------

		// Destroy
		// ---------------------------------------------------
		txrService = null;
		// ---------------------------------------------------

	}

}
