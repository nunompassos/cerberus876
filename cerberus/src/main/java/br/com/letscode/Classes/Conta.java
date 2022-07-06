package br.com.letscode.Classes;
import java.math.BigDecimal;
import br.com.letscode.App;

public class Conta {
    Integer numeroDaConta;
    User user;
    String tipoPessoa;
    BigDecimal saldo;
    BigDecimal rendimento;  
    public BigDecimal getRendimento() {
        return rendimento;
    }

    BigDecimal rendimentoExtra;
    BigDecimal taxa; // Será 0.05 para PJ e 0 para PF. SAQUE OU TRANSF.

    // Construtor
    public Conta(User user) {
        this.numeroDaConta = App.countContas;
        this.user = user;
        this.tipoPessoa = user.tipoPessoa;
        this.saldo = new BigDecimal("0.00");
        this.rendimento = new BigDecimal("0"); // ver se tem como deixar essa superclasse com esse default, ou se tem que criar ContaCorrente.java, retirando alguns campos daqui.
        this.rendimentoExtra = Personalidade.valueOf(tipoPessoa).rendimentoExtra;
        this.taxa = Personalidade.valueOf(tipoPessoa).taxa;
    }

    // Getters e Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Outros métodos


    private static void criarConta(int numero, int personalidade) {
        App.countContas++;
        // App.contas.add(new Conta());
        System.out.printf("Anota aí! O número da sua conta é", App.countContas);
    }

    public void depositar(String valor) {
        this.saldo.add(new BigDecimal(valor));
    }
    public void fazRender() {
        this.saldo = this.saldo.multiply(this.rendimento.add(this.rendimentoExtra));
    }

}
