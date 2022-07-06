package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    BigDecimal rendimento;
    BigDecimal rendimentoExtra;

    public ContaInvestimento(int numero, String tipoPessoa) {
        super(numero, tipoPessoa);
        final BigDecimal rendimento = new BigDecimal("1.02");
        final BigDecimal rendimentoExtra = Personalidade.valueOf(tipoPessoa).rendimentoExtra;
    }

}
