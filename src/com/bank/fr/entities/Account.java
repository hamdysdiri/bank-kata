package com.bank.fr.entities;

public class Account {

	private int balance;

	public Account(int accountBalance) {
		super();
		this.balance = accountBalance;
	}

	public int getAccountBalance() {
		return balance;
	}

	public void setAccountBalance(int accountBalance) {
		this.balance = accountBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (balance != other.balance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}

}
