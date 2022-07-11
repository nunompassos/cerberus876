package br.com.letscode;

import java.math.BigDecimal;

public class ContaCP extends Conta {

    ContaCP(int numeroConta, BigDecimal saldoConta) {
        super(numeroConta, TipoCliente.PF, TipoConta.CP, saldoConta);
    }

}
