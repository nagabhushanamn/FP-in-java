package com.bank.mts;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.mts.config.MTSConfig;
import com.bank.mts.service.TxrService;

public class App {

	public static void main(String[] args) {

		// Init
		// ---------------------------------------------------
		// AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
		// AccountRepository hibAccountRepository = new HibernateAccountRepository();
		// TxrServiceImpl txrService = new TxrServiceImpl();
		// txrService.setAccountRepository(hibAccountRepository);

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new AnnotationConfigApplicationContext(MTSConfig.class);

		// ---------------------------------------------------

		// Use
		// ---------------------------------------------------
		TxrService txrService = (TxrService) applicationContext.getBean("txrService");
		boolean confirm = txrService.txr(1000.00, "2", "1");
		System.out.println(confirm ? "Txr success" : "Txr failed");
		// ---------------------------------------------------

		// Destroy
		// ---------------------------------------------------
		applicationContext.close();
		// ---------------------------------------------------

	}

}
