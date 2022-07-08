package br.com.letscode.Classes;

public class ContaCorrente extends Conta {

    public ContaCorrente(User user, TipoDeConta tipoConta) {
        super(user, tipoConta);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo é de R$ " + this.getSaldo());
    }

}
