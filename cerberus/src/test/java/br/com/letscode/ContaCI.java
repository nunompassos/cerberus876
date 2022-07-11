package br.com.letscode;

import java.math.BigDecimal;

public class ContaCI extends Conta {

    ContaCI(int numeroConta, TipoCliente tipoCliente, BigDecimal saldoConta) {
        super(numeroConta, tipoCliente, TipoConta.CI, saldoConta);
    }

    public boolean transferir(BigDecimal valor, ContaCC conta) {
        return false;
    }

    public boolean transferir(BigDecimal valor, ContaCP conta) {
        return false;
    }

    public boolean resgatar(BigDecimal valor, ContaCC conta) {
        return super.transferir(valor, conta);
    }

}
