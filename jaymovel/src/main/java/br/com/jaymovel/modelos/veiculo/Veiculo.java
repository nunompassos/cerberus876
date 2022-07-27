package br.com.jaymovel.modelos.veiculo;

import br.com.jaymovel.enums.TipoVeiculo;

public class Veiculo {
	private final TipoVeiculo tipo;
	private final int chassi;
	//TODO Colocar mais campos (modelo, cor etc)

	public Veiculo(TipoVeiculo tipo, int chassi) {
		if (tipo == null)
			throw new IllegalArgumentException("Tipo de veículo não pode ser nulo");
		this.tipo = tipo;
		this.chassi = chassi;
	}

	public int getChassi() {
		return chassi;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return String.format(
			"[Tipo: %s]",
			tipo,
			chassi);
	}
}
