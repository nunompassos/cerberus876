package br.com.letscode.solid.single;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

	final Map<Integer, BankAccount> bankAccounts = new HashMap<>();

	public BigDecimal deposit(BigDecimal amount, BankAccount account) {
		account.setSaldo(account.getSaldo().add(amount));
		return account.getSaldo();
	}

	public BigDecimal withdraw(BigDecimal amount, BankAccount account) {
		account.setSaldo(account.getSaldo().subtract(amount));
		return account.getSaldo();
	}

	public void printMovements() {
		// print all movements of an account
	}

}
