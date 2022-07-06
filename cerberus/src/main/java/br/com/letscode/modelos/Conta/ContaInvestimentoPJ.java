package br.com.letscode.modelos.Conta;

import br.com.letscode.enums.Taxa;
import br.com.letscode.modelos.Pessoa.PessoaJuridica;

public class ContaInvestimentoPJ extends ContaInvestimento{

	ContaInvestimentoPJ(int numero, PessoaJuridica titular, char perfil) {
		super(numero, titular, Taxa.PJ, perfil);
	}

	@Override
	public PessoaJuridica getTitular() {
		return (PessoaJuridica) super.getTitular();
	}
}
