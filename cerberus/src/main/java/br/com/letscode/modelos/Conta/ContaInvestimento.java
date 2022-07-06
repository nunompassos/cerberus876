package br.com.letscode.modelos.Conta;

import br.com.letscode.enums.PerfilInvestidor;
import br.com.letscode.enums.Taxa;
import br.com.letscode.modelos.Pessoa.Pessoa;

public abstract class ContaInvestimento extends Conta {

	protected PerfilInvestidor perfil;

	ContaInvestimento(int numero, Pessoa titular, Taxa taxa, char perfil) {
		super(numero, titular, taxa);
		this.setPerfil(perfil);
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
