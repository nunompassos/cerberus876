package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    BigDecimal rendimento;

    public ContaPoupanca(User user) {
        super(user);
        final BigDecimal rendimento = new BigDecimal("1.005");
    }

}
