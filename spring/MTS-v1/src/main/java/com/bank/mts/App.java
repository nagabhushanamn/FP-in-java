package com.bank.mts;

import com.bank.mts.service.TxrService;
import com.bank.mts.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// Init
		// ---------------------------------------------------
		TxrService txrService = new TxrServiceImpl();
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
