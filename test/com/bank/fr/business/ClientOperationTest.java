package com.bank.fr.business;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.fr.entities.Account;
import com.bank.fr.entities.Client;

class ClientOperationTest {

	private Account account;
	private Client client;
	private ClientOperation clientOperation;

	@BeforeEach
	void setUp() {
		account = new Account();
		client = new Client(1, "ralph", account);
		clientOperation = new ClientOperation(account, 0);
	}

	@Test
	void whenClientDepositInHisAccount_ThenBalanceChanges() {
		clientOperation.deposit(50);
		assertEquals(50, client.getAccount().getBalance());

	}

	@Test
	void whenClientDepositInHisAccountInvalidateAmount_ThenAssertionErrorThrown() {

		AssertionError exception = assertThrows(AssertionError.class, () -> {
			clientOperation.deposit(-50);
		});

		String expectedMessage = "cannot deposit negative amount";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void whenClientRetreiveMoney_ThenBalanceChanges() {
		clientOperation.deposit(50);
		clientOperation.withdrawal(40);
		assertEquals(10, client.getAccount().getBalance());
	}

	@Test
	void whenClientRetreiveFromHisAccountInvalidateAmount_ThenAssertionErrorThrown() {
		AssertionError exception = assertThrows(AssertionError.class, () -> {
			clientOperation.withdrawal(-50);
		});

		String expectedMessage = "cannot deposit negative amount";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void whenClientRetriveFromHisAccountAndBalanceIsLessThanZero_ThenAssertionErrorThrown() {
		AssertionError exception = assertThrows(AssertionError.class, () -> {
			clientOperation.withdrawal(100);
		});

		String expectedMessage = "balance cannot be less than zero";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
