package br.com.letscode.Classes;

import java.math.BigDecimal;

public enum TipoDeConta {
    CORRENTE(new BigDecimal("1")),
    POUPANCA(new BigDecimal("1.005")),
    INVESTIMENTO(new BigDecimal("1.01"));

    final BigDecimal rendimento;

    TipoDeConta(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

}