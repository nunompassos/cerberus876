package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaPoupanca extends ContaCorrente {
    BigDecimal rendimento;

    public ContaPoupanca(User user, String tipoConta) {
        super(user, tipoConta);
    }

}
