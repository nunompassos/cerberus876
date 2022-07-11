package br.com.letscode;

import java.math.BigDecimal;

public enum TipoConta {

    CC(new BigDecimal("0.000")),
    CP(new BigDecimal("0.005")),
    CI(new BigDecimal("0.010"));

    final BigDecimal taxaJuros;

    TipoConta(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

}
