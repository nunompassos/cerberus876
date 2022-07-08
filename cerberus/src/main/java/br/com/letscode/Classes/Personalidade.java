package br.com.letscode.Classes;

import java.math.BigDecimal;

public enum Personalidade {

    // peculiaridades da conta jurídica:
    // 2% de rendimento a mais na conta de investimento: cauculo realizado no
    // construtor da classe ContaInvestimento.
    // Taxas de 0,5%. Cálculo realizado de acordo com o Tipo de Usuário (PF ou PJ),
    // na função Conta.sacar().

    FISICA(new BigDecimal("0"),
            new BigDecimal("0")),

    JURIDICA(new BigDecimal("0.02"),
            new BigDecimal("0.005"));

    final BigDecimal rendimentoExtra;
    final BigDecimal taxa;

    Personalidade(BigDecimal rendimentoExtra, BigDecimal taxa) {
        this.rendimentoExtra = rendimentoExtra;
        this.taxa = taxa;
    }

}