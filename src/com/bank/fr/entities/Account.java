package com.bank.fr.entities;

import java.util.ArrayList;
import java.util.List;

import com.bank.fr.business.ClientOperation;

public class Account {

	private int balance = 0;
	private List<ClientOperation> operations = new ArrayList<>();

	public Account(int balance) {
		super();
		this.balance = balance;
	}
	
	public Account() {
		
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<ClientOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<ClientOperation> operations) {
		this.operations = operations;
	}

	public void saveHistory(Account account, int amount) {
		operations.add(new ClientOperation(account, amount));
	}

	public void printHistory() {
		System.out.println("Account Balance=" + getBalance() + "\n" + "History:");
		operations.forEach(x -> {
			System.out.println("Date=" + x.getAmountDate());
			System.out.println("Amount=" + x.getAmount() + "");
		});
	}

}
