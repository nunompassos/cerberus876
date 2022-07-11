package br.com.letscode.contas;

import java.math.BigDecimal;
import br.com.letscode.clientes.Cliente;
import br.com.letscode.clientes.ClientePJ;

public abstract class Conta {
    // Definição dos atributos/características
    
    protected BigDecimal taxaTransacional;
    private static int codigoGerado;
    private Cliente titular;
    private int numeroDaConta;
    private BigDecimal saldo;
    
    // Definição dos métodos/comportamentos

    public Conta(Cliente titular){
        this.titular = titular;
        this.setTaxaTransacional();
        this.saldo = BigDecimal.ZERO;
        this.numeroDaConta = Conta.codigoGerado + 1000;
        Conta.codigoGerado += 1;
    }

    public void sacar(BigDecimal valor){
        BigDecimal valorComTaxa = valor.multiply(this.getTaxaTransacional());
        if(temSaldoSuficienteParaMovimentar(valorComTaxa)){
            this.saldo = this.saldo.subtract(valorComTaxa);
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public boolean temSaldoSuficienteParaMovimentar(BigDecimal valor){
        if(this.saldo.compareTo(valor)==-1){
            return false;
        }
        return true;
    }

    public boolean isPessoaJuridica(){
        if(this.titular instanceof ClientePJ){
            return true;
        }
        return false;
    }

    public boolean isPropriaConta(Conta destino){
        if(this.equals(destino)){
            return true;
        }
        return false;
    }

    public void depositar(double valor){
        this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
        System.out.println("Depósito realizado com sucesso.");
    }

    public void transferir(BigDecimal valorDaTransferencia, Conta contaDeDestino){
        BigDecimal valorComTaxa = valorDaTransferencia.multiply(this.getTaxaTransacional());
        if(!this.isPropriaConta(contaDeDestino)){
            if(temSaldoSuficienteParaMovimentar(valorComTaxa)){
                contaDeDestino.setSaldo(
                    contaDeDestino.getSaldo()
                    .add(valorDaTransferencia)
                );
    
                this.setSaldo(
                    this.getSaldo()
                    .subtract(valorComTaxa)
                );
            } else {
                System.out.println("Saldo insuficiente para realizar a transferência.");
            }
        } else {
            System.out.println("Não pode transferir para si próprio.");
        }
    }

    public void consultarSaldo(){
        System.out.println("O saldo da conta "+this.numeroDaConta+" é "+this.getSaldo());
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public int getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public BigDecimal getTaxaTransacional() {
        return taxaTransacional;
    }

    public void setTaxaTransacional() {
        if(this.isPessoaJuridica()){
            this.taxaTransacional = BigDecimal.valueOf(1.05);
        } else {
            this.taxaTransacional = BigDecimal.valueOf(1);
        }
    }

    @Override
    public boolean equals(Object obj){
        Conta outraConta = (Conta) obj;
        if(this.numeroDaConta == outraConta.numeroDaConta){
            return true;
        }
        return false;
    }

}