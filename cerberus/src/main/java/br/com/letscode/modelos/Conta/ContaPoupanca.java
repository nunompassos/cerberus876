package br.com.letscode.modelos.Conta;

import br.com.letscode.modelos.Pessoa.PessoaFisica;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int numero, PessoaFisica titular) {
		super(numero, titular, Taxa.PF);
	}

	@Override
	public void passarMes() {
		long rendimento = Math.round(super.saldo * super.taxa.getRendimento());
		this.saldo += rendimento;
	}

	@Override
	public PessoaFisica getTitular() {
		return (PessoaFisica) super.getTitular();
	}

	@Override
	public String toString() {
		return "CP: {" + super.toString() + 
				'}';
	}
}
