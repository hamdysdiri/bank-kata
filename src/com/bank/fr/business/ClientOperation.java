package com.bank.fr.business;

import java.time.LocalDateTime;

import com.bank.fr.entities.Account;

public class ClientOperation {

	private Account account;
	private final LocalDateTime amountDate;
	private int amount;

	public ClientOperation(Account account) {
		super();
		this.account = account;
		this.amountDate = LocalDateTime.now();
	}

	public LocalDateTime getAmountDate() {
		return amountDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void operation(OperationType deposit, int amount) {
		switch (deposit) {
		case DEPOSIT:
			validate(amount);
			setAmount(amount);
			updateBalance();
			break;
		default:
			throw new IllegalArgumentException("Unkown Operation.");
		}

	}

	private void validate(int amount) {
		assert amount > 0 : "cannot deposit negative amount";

	}

	private void updateBalance() {
		this.account.setAccountBalance(this.account.getAccountBalance() + getAmount());
	}
}
