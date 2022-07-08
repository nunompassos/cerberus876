package br.com.letscode.Classes;

// Extende a conta corrente, porque lá já tem a função de ver saldo,
// que sobrescreve a da classe pai.
public class ContaPoupanca extends ContaCorrente {

    public ContaPoupanca(User user, TipoDeConta tipoConta) {
        super(user, tipoConta);
    }

}
