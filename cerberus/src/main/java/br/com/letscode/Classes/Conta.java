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
        this.rendimento = new BigDecimal("1");
        this.taxa = Personalidade.valueOf(tipoPessoa).taxa;
    }
    
    // Getters e Setters
    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public String getTipoPessoa() {
        return tipoPessoa;
    }
    
    public BigDecimal getTaxa() {
        return taxa;
    }

    // Outros métodos
    
    private static void criarConta(int numero, int personalidade) {
        App.countContas++;
        // App.contas.add(new Conta());
        System.out.printf("Anota aí! O número da sua conta é", App.countContas);
    }

    public final void depositar(String valor) {
        this.saldo = this.saldo.add(new BigDecimal(valor));
    }

    public void sacar(String valor) {
        BigDecimal valorBD = new BigDecimal(valor);
        BigDecimal custoTotal = (valorBD.multiply(taxa).add(valorBD));
        if (custoTotal.compareTo(this.saldo) > 0) {
            System.out.println("Impossivel realizar esta operação");
        }
       else {
        this.saldo = this.saldo.subtract(custoTotal);
    }
    }
}