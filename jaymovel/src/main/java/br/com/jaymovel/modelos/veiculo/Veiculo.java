package br.com.jaymovel.modelos.veiculo;

import br.com.jaymovel.enums.TipoVeiculo;

public class Veiculo {
	private TipoVeiculo tipo;
	private int chassi;
	//TODO Colocar mais campos (modelo, cor etc)

	public Veiculo(TipoVeiculo tipo) {
		if (tipo == null)
			throw new IllegalArgumentException("Tipo de veículo não pode ser nulo");
		this.tipo = tipo;
	}

	public int getChassi() {
		return chassi;
	}

	public void setChassi(int chassi) {
		this.chassi = chassi;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String.format(
			"[Tipo: %s, Chassi: %d]",
			tipo,
			chassi);
	}
}
