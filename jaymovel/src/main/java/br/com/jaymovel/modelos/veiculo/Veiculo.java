package br.com.jaymovel.modelos.veiculo;

import br.com.jaymovel.enums.TipoVeiculo;

public class Veiculo {
	private TipoVeiculo tipo;
	//TODO Colocar mais campos (modelo, cor etc)

	public Veiculo(TipoVeiculo tipo) {
		if (tipo == null)
			throw new IllegalArgumentException("Tipo de veículo não pode ser nulo");
		this.tipo = tipo;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}
}
