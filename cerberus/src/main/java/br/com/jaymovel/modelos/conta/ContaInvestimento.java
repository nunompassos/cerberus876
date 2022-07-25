package br.com.jaymovel.modelos.conta;

import br.com.jaymovel.enums.PerfilInvestidor;
import br.com.jaymovel.modelos.pessoa.Pessoa;

public class ContaInvestimento extends Conta {

	private static final long serialVersionUID = 2200000L;

	protected PerfilInvestidor perfil;

	public ContaInvestimento(int numero, Pessoa titular) {
		super(numero, titular);
		this.setPerfil('C');
	}

	public PerfilInvestidor getPerfil() {
		return perfil;
	}

	public void setPerfil(char perfil) {
		PerfilInvestidor p = PerfilInvestidor.deChar(perfil);
		if (p == null)
			throw new IllegalArgumentException("Perfil " + perfil + "inválido");
		this.perfil = p;
	}

	@Override
	public void passarMes() {
		double taxaRendimento = this.perfil.getVariacao() + super.taxa.getRendimento();
		long rendimento = Math.round(super.saldo * taxaRendimento);
		this.saldo += rendimento;
	}

	@Override
	public String toString() {
		return "CI: {" + super.toString() +
				'}';
	}

}
