package br.com.pedro.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca extends Conta {

    private ClientePessoaFisica pessoa;
    private final double correcaoPoupancaAnual = 0.03;

    public ContaPoupanca(Agencia agencia, int numeroConta, ClientePessoaFisica clientePessoaFisica)
            throws ContaException {
        super(agencia, numeroConta);
        this.pessoa = clientePessoaFisica;
        clientePessoaFisica.adicionarConta(this);
    }

    public Number[] poupar(BigDecimal valor, int dias) throws ContaException {
        this.sacar(valor);
        double taxaDia = Math.pow(1.0 + correcaoPoupancaAnual, (1 / 360.0)) - 1;
        BigDecimal taxaAplicada = BigDecimal.valueOf(Math.pow(1 + taxaDia, dias) - 1).setScale(5, RoundingMode.UP);
        BigDecimal rendimento = valor.multiply(taxaAplicada).setScale(2, RoundingMode.UP);
        this.setSaldo(this.getSaldo().add(valor.add(rendimento)));
        return new Number[]{taxaAplicada, correcaoPoupancaAnual, rendimento};
    }

    public ClientePessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(ClientePessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Nome ...........: " + this.pessoa.getNome() + "\n"
                + "CPF ............: " + this.pessoa.getCpf() + "\n"
                + super.toString();
    }
}
