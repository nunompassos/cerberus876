package br.com.letscode.modelos.Conta;

import br.com.letscode.modelos.Pessoa.PessoaFisica;

public class ContaInvestimentoPF extends ContaInvestimento{

	ContaInvestimentoPF(int numero, PessoaFisica titular, char perfil) {
		super(numero, titular, Taxa.PF, perfil);
	}

	@Override
	public PessoaFisica getTitular() {
		return (PessoaFisica) super.getTitular();
	}
}
