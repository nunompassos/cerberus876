package br.com.letscode.aula6.bancario.contas;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public abstract class Conta {

    private BigDecimal saldo = BigDecimal.ZERO;

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    protected BigDecimal sacar(BigDecimal valor) {
        if (saldo.compareTo(valor) < 0) {
            throw new InvalidParameterException();
        }
        this.saldo = saldo.subtract(valor);
        return this.saldo;
    }

    public BigDecimal depositar(final BigDecimal valor) {
        saldo = saldo.add(valor);
        return saldo;
    }

}
