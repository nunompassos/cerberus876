package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    BigDecimal rendimento;
    BigDecimal rendimentoExtra;

    public ContaInvestimento(User user) {
        super(user);
        super.rendimento = TipoDeConta.INVESTIMENTO.rendimento;
        this.rendimentoExtra = Personalidade.valueOf(tipoPessoa).rendimentoExtra;
    }
}
