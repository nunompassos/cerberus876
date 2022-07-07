package br.com.letscode.Classes;

import java.math.BigDecimal;
import br.com.letscode.App;

public class Conta {
    private Integer numeroDaConta;
    private User user;
    private String tipoPessoa;
    private String tipoConta;
    private BigDecimal saldo;

    protected BigDecimal rendimento;

    private BigDecimal taxa;

    // Construtor
    public Conta(User user, String tipoConta) {
        this.numeroDaConta = App.contas.size();
        this.user = user;
        this.tipoPessoa = user.tipoPessoa;
        this.tipoConta = tipoConta;
        this.saldo = new BigDecimal("0.00");
        this.rendimento = TipoDeConta.valueOf(tipoConta).rendimento;
        // Já considera o rendimento de + 2% se a conta for de investimento/pessoa
        // física. Está puxando dos Enums.
        this.taxa = Personalidade.valueOf(tipoPessoa).taxa; // Puxa do ENUM: 0.5% para PJ e 0% para PF. Aplica-se a
        // saque e transf.
    }

    // Getters e Setters
    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getSaldo() {
        return saldo;

    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    // Outros métodos
    public boolean sacar(String valor) {
        BigDecimal valorBD = new BigDecimal(valor);
        BigDecimal taxaOperacao = valorBD.multiply(this.taxa);
        BigDecimal custoTotal = valorBD.add(taxaOperacao);
        System.out.println("A taxa para esta operação é de R$: " + taxaOperacao);
        System.out.println("Este é o custo total: " + custoTotal);
        if (custoTotal.compareTo(this.saldo) > 0) {
            System.out.println("Saldo insuficiente.");
            return false;
        } else {
            this.saldo = saldo.subtract(custoTotal);
            return true;
        }
    }

    public final void depositar(Conta conta, String valor) {
        conta.saldo = conta.saldo.add(new BigDecimal(valor));
    }

    public final void transferir(Conta destino, String valor) {
        if (sacar(valor)) { depositar(destino, valor); }
    }

    public final void investir(Conta origem, ContaInvestimento destino, String valor) {
        BigDecimal valorBD = new BigDecimal(valor);

        if (valorBD.compareTo(this.saldo) > 0) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.saldo = this.saldo.subtract(valorBD);
            depositar(destino, valor);
            // já considera, pelo user da conta destino, se é PJ ou PF.
        }
    }
}