package br.com.letscode.modelos.Conta;

import br.com.letscode.modelos.Pessoa.PessoaJuridica;

public class ContaCorrentePJ extends ContaCorrente {
	
	public ContaCorrentePJ(int numero, PessoaJuridica titular) {
		super(numero, titular, Taxa.PJ);
	}

	@Override
	public PessoaJuridica getTitular() {
		return (PessoaJuridica) super.getTitular();
	}
}
