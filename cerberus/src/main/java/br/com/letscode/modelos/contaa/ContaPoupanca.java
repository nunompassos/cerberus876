package br.com.letscode.modelos.contaa;

import br.com.letscode.modelos.pessoaa.PessoaFisica;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int numero, PessoaFisica titular) {
		super(numero, titular);
	}

	@Override
	public void passarMes() {
		long rendimento = Math.round(super.saldo * super.taxa.getRendimento());
		this.saldo += rendimento;
	}

	@Override
	public String toString() {
		return "CP: {" + super.toString() + 
				'}';
	}
}
