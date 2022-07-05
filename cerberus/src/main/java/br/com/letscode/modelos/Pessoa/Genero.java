package br.com.letscode.modelos.Pessoa;

import java.util.HashMap;

public enum Genero {
	MASCULINO('M', "Masculino"),
	FEMININO('F', "Feminino"),
	OUTRO('O', "Outro");

	private static final class MapaInterno {
		private static final HashMap<Character, Genero> map = new HashMap<Character, Genero>();
	}

	private final char valor;
	private final String valorCheio;

	Genero(char genero, String generoCheio) {
		this.valor = genero;
		this.valorCheio = generoCheio;
		MapaInterno.map.put(genero, this);
	}
 
	public static Genero deChar(char genero) {
		return MapaInterno.map.get(genero);
	}

	public char getValor() {
		return this.valor;
	}

	@Override
	public String toString() {
		return this.valorCheio;
	}
}
