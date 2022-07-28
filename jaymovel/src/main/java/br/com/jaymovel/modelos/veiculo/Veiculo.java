package br.com.jaymovel.modelos.veiculo;

import br.com.jaymovel.enums.TipoVeiculo;

public class Veiculo {
	private final TipoVeiculo tipo;
	private final int chassi;
	private final String marca;
	private final String modelo;
	private final int ano;
	private String cor;

	public Veiculo(
			TipoVeiculo tipo,
			int chassi,
			String marca,
			String modelo,
			int ano,
			String cor) {
		if (tipo == null)
			throw new IllegalArgumentException("Tipo de veículo não pode ser nulo");
		this.tipo = tipo;
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
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
				"%s %s %s %s, Tipo: %s",
				marca,
				modelo,
				ano,
				cor,
				tipo,
				chassi);
	}
}
