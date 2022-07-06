package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    BigDecimal rendimento;
    BigDecimal rendimentoExtra;

    public ContaInvestimento(User user) {
        super(user);
        final BigDecimal rendimento = TipoDeConta.INVESTIMENTO.rendimento;
        final BigDecimal rendimentoExtra = Personalidade.valueOf(tipoPessoa).rendimentoExtra;
    }

}
