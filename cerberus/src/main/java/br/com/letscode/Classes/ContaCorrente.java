package br.com.letscode.Classes;

import java.math.BigDecimal;

public class ContaCorrente {
    Integer numeroDaConta;
    TipoDeConta tipo;
    BigDecimal saldo;
    BigDecimal taxaRendimento;
    // saque ou transferencia
    BigDecimal taxa; // Será 0.05 para PJ e 0 para PF.

    // Construtor
    public ContaCorrente(TipoDeConta tipo) {
        this.numeroDaConta = Integer.valueOf(contasExistentes.size());
        this.tipo = tipo;
        this.saldo = new BigDecimal("1,00");
    }

    // Getters e Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Outros métodos
    public void fazRender() {
        this.saldo = this.saldo.multiply(taxaRendimento);
    }

}
