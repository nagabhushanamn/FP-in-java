package com.bank.mts.service;

import com.bank.mts.model.Account;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.JdbcAccountRepository;

/*
 *  design  & performance issues
 *  -----------------------------
 *  
 *    --> tight-coupling
 *    --> too many dependencies are created & destructed
 *    --> unit-testing not possible
 *   
 *   
 *    why these issues ?
 *    
 *     --> dependent itself creating it's own dependeny
 *     
 *     soln: 
 *     
 *     		don't create , do Lookup
 *     
 *     	limitation on lookup:
 *     
 *     		--> location tight-coupling
 *     
 *     best soln :
 *     
 *     		--> don't create/lookup , inject thru 'container'  ( Inversion of Control )
 *     
 *     
 *     how to implement IOC ?
 *     
 *     		==> dependency injection
 *     
 *     		how
 *     
 *     			-> using constructor
 *     			-> using setter
 *              -> using field
 *              -> method
 *              
 *         --------------------------------------------------------------
 *         
 *          ref : https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)
 *          
 *         -------------------------------------------------------      
 *               
 *     			
 * 
 */

public class TxrServiceImpl implements TxrService {

	public boolean txr(double amount, String fromAccNum, String toAccNum) {
		AccountRepository accountRepository = new JdbcAccountRepository();
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
