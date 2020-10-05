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

	private void setAmount(int amount) {
		this.amount = amount;
	}

	public void deposit(int amount) {
		validateAmount(amount);
		setAmount(amount);
		account.setBalance(this.account.getBalance() + getAmount());
		account.saveHistory(account, amount);

	}

	public void withdrawal(int amount) {
		validateAmount(amount);
		validateBalanceWithDrawal(amount);

		setAmount(amount);
		account.setBalance(this.account.getBalance() - getAmount());
		account.saveHistory(account, amount);

	}

	private void validateAmount(int amount) {
		assert amount > 0 : "cannot deposit negative amount";

	}

	private void validateBalanceWithDrawal(int amount) {
		assert this.account.getBalance() - amount > 0 : "balance cannot be less than zero";
	}

}
