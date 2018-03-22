package com.bank.mts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS", schema = "mts")
public class Account {

	@Id
	private String num;
	@Column(name = "balanace")
	private double balance;
	@Column(name = "acc_type")
	@Enumerated(EnumType.STRING)
	private AccountType type;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + ", type=" + type + "]";
	}
	
	

}
