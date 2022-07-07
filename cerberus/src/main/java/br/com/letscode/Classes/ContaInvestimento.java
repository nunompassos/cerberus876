package br.com.letscode.Classes;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(User user, TipoDeConta tipoConta) {
        super(user, tipoConta);
        super.rendimento = tipoConta.rendimento
        .add(user.getTipoPessoa().rendimentoExtra);
    }
}
