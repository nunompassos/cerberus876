package br.com.letscode.Classes;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(User user, TipoDeConta tipoConta) {
        super(user, tipoConta);
        super.rendimento = tipoConta.rendimento
                .add(user.getTipoPessoa().rendimentoExtra);
    }

    @Override
    public void investir(String valor) {
        this.setSaldo(this.getSaldo().add(new BigDecimal(valor)));
        System.out.println("Investimento realizado com sucesso. Você possui " + this.getSaldo()
                + " investidos. Faça passar o mês (menu nº 7) para ver o rendimento.");

    }
}
