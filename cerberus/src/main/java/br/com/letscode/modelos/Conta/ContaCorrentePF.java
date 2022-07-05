package br.com.letscode.modelos.Conta;

import br.com.letscode.modelos.Pessoa.PessoaFisica;

public class ContaCorrentePF extends ContaCorrente {
	
	public ContaCorrentePF(int numero, PessoaFisica titular) {
		super(numero, titular, Taxa.PF);
	}

	@Override
	public PessoaFisica getTitular() {
		return (PessoaFisica) super.getTitular();
	}
}