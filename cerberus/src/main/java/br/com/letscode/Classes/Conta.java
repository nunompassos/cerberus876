package br.com.letscode.Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.letscode.App;

public abstract class Conta {
    private Integer numeroDaConta;
    protected User user;
    protected Personalidade tipoPessoa;
    protected TipoDeConta tipoConta;
    protected BigDecimal saldo;
    protected BigDecimal rendimento;
    private BigDecimal taxa;

    // Construtor
    public Conta(User user, TipoDeConta tipoConta) {
        this.numeroDaConta = App.contas.size();
        this.user = user;
        this.tipoPessoa = user.getTipoPessoa();
        this.tipoConta = tipoConta;
        this.saldo = new BigDecimal("0.00");
        this.rendimento = tipoConta.rendimento;
        // Já considera o rendimento de + 2% se a conta for de investimento/pessoa
        // física. Está puxando 2 Enums relativos ao tipo de conta e com o tipo de
        // usuário (PF ou PJ).
        this.taxa = tipoPessoa.taxa;
        // Puxa do ENUM TipoDePessoa: 0.5% para PJ e 0% para PF. Aplica-se a saques e
        // transferências.
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

    public Personalidade getTipoPessoa() {
        return tipoPessoa;
    }

    public TipoDeConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    // Outros métodos
    public boolean sacar(String valor) {
        BigDecimal valorBD = new BigDecimal(valor);
        BigDecimal taxaOperacao = valorBD.multiply(this.taxa).setScale(2, RoundingMode.HALF_UP);
        BigDecimal custoTotal = valorBD.add(taxaOperacao);
        System.out.println("A taxa para esta operação é de R$: " + taxaOperacao);
        System.out.println("Custo total da operação: " + custoTotal);
        if (custoTotal.compareTo(this.saldo) > 0) {
            System.out.println("Saldo insuficiente.");
            return false;
        } else {
            this.saldo = saldo.subtract(custoTotal);
            return true;
        }
    }

    public static final void depositar(Conta conta, String valor) {
        conta.saldo = conta.saldo.add(new BigDecimal(valor));
    }

    //
    public final void transferir(Conta destino, String valor) {
        if (sacar(valor)) {
            depositar(destino, valor);
            System.out.println("\nTransação realizada com sucesso.");
        }
    }

    public void investir(String msg) {
        msg = "\nNão é possível investir nesta modalidade: CONTA " + this.getTipoConta() + ".\n";
        System.out.println(msg);
    }
    public abstract void consultarSaldo();

    // Já que a conta de Investimento não está listada no enunciado para consulta de
    // saldo, Coloquei como abstrato, para que na contaInvestimento, retorne uma mensagem.
    // Na subclasse ContaCorrente está a implementação real da consulta de saldo, que foi extendido via herança
    // à conta poupança.

    public String rendimentoFormatter() { 
        BigDecimal rendTemp = new BigDecimal(100).multiply(this.rendimento.subtract(new BigDecimal(1)));
        String rendStr = rendTemp.setScale(1, RoundingMode.HALF_EVEN).toString() + "%";
        
        return rendStr;
    }
    
    @Override
    public String toString() {
        return "Conta número " + numeroDaConta + ", " + tipoConta + ". Saldo: " + saldo.setScale(2) + "  (User ID: "
                + this.user.getId() + ", PESSOA "
                + tipoPessoa + ".)";
    }

}
