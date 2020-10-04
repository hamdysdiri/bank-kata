package com.bank.fr.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.bank.fr.entities.Account;

public class ClientOperation {

	private Account account;
	private final LocalDateTime amountDate;
	private int amount;

	public ClientOperation(Account account, int amount) {
		super();
		this.account = account;
		this.amountDate = LocalDateTime.now();
		this.amount = amount;
	}

	public String getAmountDate() {
		DateTimeFormatter meduimDateForm = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return meduimDateForm.format(amountDate);
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
			account.setBalance(this.account.getBalance() + getAmount());
			account.saveHistory(account, amount);
			break;
		case WITHDRAWAL:
			validate(amount);
			setAmount(amount);
			account.setBalance(this.account.getBalance() - getAmount());
			account.saveHistory(account, amount);
			break;
		default:
			throw new IllegalArgumentException("Unkown Operation.");
		}

	}

	private void validate(int amount) {
		assert this.account.getBalance() >= amount : "balance cannot be less than zero";
		assert amount > 0 : "cannot deposit negative amount";

	}

}
