package br.com.letscode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Conta {

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

    public String saldo() {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        return df.format(saldoConta);
    }

    public boolean sacar(BigDecimal valor) {
        // (1) Calcula Taxa Saque
        BigDecimal taxaSaque = new BigDecimal("0.000");
        if (tipoConta == TipoConta.CC) {
            taxaSaque = tipoCliente.taxaSaque;
        }
        // (2) Calcula Valor Taxa
        BigDecimal valorTaxa = valor.multiply(taxaSaque);
        valorTaxa = valorTaxa.setScale(2, RoundingMode.HALF_UP);
        // (3) Calcula Valor Final
        BigDecimal valorFinal = valor.add(valorTaxa);
        // (4) Verifica Saldo Conta
        if (valorFinal.compareTo(saldoConta) <= 0) {
            // (5) Realiza Saque
            saldoConta = saldoConta.subtract(valorFinal);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(BigDecimal valor) {
        // (1) Calcula Taxa Juros
        BigDecimal taxaJuros = tipoConta.taxaJuros;
        if ((tipoCliente == TipoCliente.PJ) && (tipoConta == TipoConta.CI)) {
            taxaJuros = taxaJuros.add(new BigDecimal("0.020"));
        }
        // (2) Calcula Valor Juros
        BigDecimal valorJuros = valor.multiply(taxaJuros);
        valorJuros = valorJuros.setScale(2, RoundingMode.HALF_UP);
        // (3) Calcula Valor Final
        BigDecimal valorFinal = valor.add(valorJuros);
        // (4) Realiza Depósito
        saldoConta = saldoConta.add(valorFinal);
        return true;
    }

    public boolean investir(BigDecimal valor) {
        // (1) Verifica Saldo Conta
        if (valor.compareTo(saldoConta) <= 0) {
            // (5) Realiza Investimento
            saldoConta = saldoConta.subtract(valor);
            return true;
        } else {
            return false;
        }
    }

}
