package br.com.letscode.Classes;
import java.math.BigDecimal;
import br.com.letscode.App;

public class Conta {
    Integer numeroDaConta;
    String tipoPessoa;
    BigDecimal saldo;
    BigDecimal rendimento;  
    BigDecimal rendimentoExtra;
    // saque ou transferencia
    BigDecimal taxa; // Será 0.05 para PJ e 0 para PF.

    // Construtor
    public Conta(int numero, String tipoPessoa) {
        this.numeroDaConta = numero;
        this.tipoPessoa = tipoPessoa;
        this.saldo = new BigDecimal("0,00");
        this.rendimento = new BigDecimal("0");
        this.rendimentoExtra = Personalidade.valueOf(tipoPessoa).rendimentoExtra;
        this.taxa = Personalidade.valueOf(tipoPessoa).taxa;
    }

    // Getters e Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Outros métodos


    private static void criarConta(int tipoInt, int personalidade) {
        App.countContas++;
        // App.contas.add(new Conta());
        System.out.printf("Anota aí! O número da sua conta é", App.countContas);
    }

    public void fazRender() {
        this.saldo = this.saldo.multiply(this.rendimento.add(this.rendimentoExtra));
    }

}
