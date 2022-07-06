package br.com.letscode.Classes;
import java.math.BigDecimal;


public enum TipoDeConta {
    CORRENTE(new BigDecimal("0")),
    POUPANCA(new BigDecimal ("1")),
    INVESTIMENTO(new BigDecimal ("1"));

    BigDecimal taxaRendimento;
    TipoDeConta(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

}