package com.bank.mts.service;

public interface TxrService {
	boolean txr(double amount,String fromAccNum,String toAccNum);
}
