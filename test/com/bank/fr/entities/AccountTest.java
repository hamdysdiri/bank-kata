package com.bank.fr.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.fr.business.ClientOperation;

class AccountTest {

	private Account account;
	

	@BeforeEach
	void setUp() {
		account = new Account();
		new Client(1, "ralph", account);
		new ClientOperation(account, 0);
	}

	@Test
	void whenClientOpenAccount_ThenBalanceIsZero() {
		assertEquals(0, account.getBalance());

	}
	
	@Test
	void whenClientToHistoryAccount_ThenHistoryChanges() {
		account.saveHistory(account, 9);
		assertEquals(1, account.getOperations().size());

	}


}
