package br.com.letscode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Conta {
    private final int numeroConta;
    private final TipoCliente tipoCliente;
    private final TipoConta tipoConta;
    private BigDecimal saldoConta;

    Conta(
            int numeroConta,
            TipoCliente tipoCliente,
            TipoConta tipoConta,
            BigDecimal saldoConta) {
        this.numeroConta = numeroConta;
        this.tipoCliente = tipoCliente;
        this.tipoConta = tipoConta;
        this.saldoConta = saldoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public String getSaldoConta(String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(saldoConta);
    }

    public boolean sacar(BigDecimal valor) {
        if (valor.compareTo(saldoConta) <= 0) {
            saldoConta = saldoConta.subtract(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(BigDecimal valor) {
        saldoConta = saldoConta.add(valor);
        return true;
    }

    public boolean transferir(BigDecimal valor, ContaCC conta) {
        if (sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(BigDecimal valor, ContaCP conta) {
        if (sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public void render() {
        BigDecimal taxaJuros = tipoConta.taxaJuros;
        if (tipoCliente == TipoCliente.PJ && tipoConta == TipoConta.CI) {
            taxaJuros = taxaJuros.add(new BigDecimal("0.020"));
        }
        taxaJuros = saldoConta.multiply(taxaJuros);
        taxaJuros = taxaJuros.setScale(2, RoundingMode.HALF_UP);
        saldoConta = saldoConta.add(taxaJuros);
    }

}
