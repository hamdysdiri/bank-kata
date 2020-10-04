package com.bank.fr.entities;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.fr.business.ClientOperation;
import com.bank.fr.business.OperationType;

class AccountTest {

	private Account account;
	private Client client;
	private ClientOperation clientOperation;

	@BeforeEach
	void setUp() {
		account = new Account(90);
		client = new Client(1, "ralph", account);
		clientOperation = new ClientOperation(account);
	}

	@Test
	void whenClientDepositInHisAccount_ThenBalanceChanges() {
		clientOperation.operation(OperationType.DEPOSIT, 50);
		assertEquals(140, client.getAccount().getAccountBalance());

	}

	@Test
	void whenClientDepositInHisAccountInvalidateAmount_ThenAssertionErrorThrown() {

		AssertionError exception = assertThrows(AssertionError.class, () -> {
			clientOperation.operation(OperationType.DEPOSIT, -50);
		});

		String expectedMessage = "cannot deposit negative amount";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void whenClientMakeUnkownOperation_ThenIllegalExceptionThrown() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			clientOperation.operation(OperationType.UNKOWN, 50);
		});

		String expectedMessage = "Unkown Operation";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void whenClientRetreiveMoney_ThenBalanceChanges() {
		clientOperation.operation(OperationType.WITHDRAWAL, 50);
		assertEquals(40, client.getAccount().getAccountBalance());
	}

	@Test
	void whenClientRetreiveFromHisAccountInvalidateAmount_ThenAssertionErrorThrown() {
		AssertionError exception = assertThrows(AssertionError.class, () -> {
			clientOperation.operation(OperationType.WITHDRAWAL, -50);
		});

		String expectedMessage = "cannot deposit negative amount";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
