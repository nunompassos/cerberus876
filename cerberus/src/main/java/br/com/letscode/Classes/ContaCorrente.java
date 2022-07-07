package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    public ContaCorrente(User user, String tipoConta) {
        super(user, tipoConta);
    }

    public void consultarSaldo() {
        System.out.println("Seu saldo é de R$ " + this.getSaldo());
    }

}
