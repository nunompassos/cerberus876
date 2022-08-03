package br.com.letscode.contas.exception;

import java.math.BigDecimal;

public class ContaException extends Exception {

    private ContaException() {
        super();
    }

    private ContaException(String msg) {
        super(msg);
    }

    public static ContaException saldoInsuficiente() {
        return new ContaException("O saldo é inferior ao valor da operação");
    }

    public static ContaException saldoInsuficiente(BigDecimal saldo, BigDecimal valor) {
        return new ContaException("O saldo " + saldo.toString() + " é inferior ao valor da operação " + valor.toString());
    }

    public static ContaException contaInvalida() {
        return new ContaException("A conta não é válida!");
    }

    public static ContaException contaInvalida(String numeroConta) {
        return new ContaException("A conta " + numeroConta + " não é válida!");
    }

}
