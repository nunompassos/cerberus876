package br.com.letscode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCC extends Conta {

    ContaCC(int numeroConta, TipoCliente tipoCliente, BigDecimal saldoConta) {
        super(numeroConta, tipoCliente, TipoConta.CC, saldoConta);
    }

    public boolean sacar(BigDecimal valor) {
        BigDecimal valorFinal = valor.multiply(getTipoCliente().taxaSaque);
        valorFinal = valorFinal.setScale(2, RoundingMode.HALF_UP);
        valorFinal = valor.add(valorFinal);
        return super.sacar(valorFinal);
    }

    public boolean investir(BigDecimal valor, ContaCI conta) {
        if (super.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

}
