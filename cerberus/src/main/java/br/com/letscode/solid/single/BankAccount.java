package br.com.letscode.solid.single;

import java.math.BigDecimal;

public class BankAccount {
    private final int numeroConta;
    private BigDecimal saldo;

    public BankAccount(final int numeroConta, final BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.setSaldo(saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        if (BigDecimal.ZERO.compareTo(saldo) >= 0) {
            this.saldo = saldo;
        }
    }
}
