package br.com.letscode.modelos;

import br.com.letscode.modelos.conta.ContaCorrente;
import br.com.letscode.modelos.conta.ContaInvestimento;
import br.com.letscode.modelos.conta.ContaPoupanca;

public class Cadastro {
	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;
	private ContaInvestimento contaInvestimento;

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}
	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
	public ContaInvestimento getContaInvestimento() {
		return contaInvestimento;
	}
	public void setContaInvestimento(ContaInvestimento contaInvestimento) {
		this.contaInvestimento = contaInvestimento;
	}

}
