package br.com.letscode;

import java.math.BigDecimal;

public enum TipoCliente {

    PF(new BigDecimal("0.000")),
    PJ(new BigDecimal("0.005"));

    final BigDecimal taxaSaque;

    TipoCliente(BigDecimal taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

}