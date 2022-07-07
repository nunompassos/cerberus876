package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    BigDecimal rendimento;

    public ContaInvestimento(User user, String tipoConta) {
        super(user, tipoConta);
        super.rendimento = TipoDeConta.valueOf(tipoConta).rendimento
        .add(Personalidade.valueOf(user.tipoPessoa).rendimentoExtra);
    }
}
