package br.com.pedro.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrentePessoaJuridica extends Conta {

    private ClientePessoaJuridica empresa;
    private BigDecimal taxa_PJ = BigDecimal.valueOf(0.05);

    public ContaCorrentePessoaJuridica(Agencia agencia, int numeroConta, ClientePessoaJuridica empresa) throws ContaException {
        super(agencia, numeroConta);
        this.empresa = empresa;
        empresa.adicionarConta(this);
    }

    public ClientePessoaJuridica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ClientePessoaJuridica empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return this.empresa + "\n"
        + super.toString();
    }

    @Override
    public void sacar(BigDecimal valor) throws ContaException {
        BigDecimal taxa = valor.multiply(taxa_PJ);
        super.sacar(valor.add(taxa));
    }

    @Override
    public void transferir(int numeroAgencia, int numeroConta, BigDecimal valor) throws ContaException, AgenciaException {
        this.sacar(valor);
        Agencia.getAgencia(numeroAgencia).getConta(numeroConta).depositar(valor);
    }

    @Override
    public BigDecimal investir(BigDecimal valor, int dias) throws ContaException {
        BigDecimal taxaAplicada = super.investir(valor, dias).add(BigDecimal.valueOf(0.02));
        BigDecimal rendimento = valor.multiply(taxaAplicada).setScale(2, RoundingMode.UP);
        this.setSaldo(this.getSaldo().add(rendimento));
        return taxaAplicada;
    }
}
