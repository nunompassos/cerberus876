package br.com.letscode.Classes;
import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    BigDecimal rendimento;

    public ContaPoupanca(int numero, String tipoPessoa) {
        super(numero, tipoPessoa);
        final BigDecimal rendimento = new BigDecimal("1.005");
    }

}
