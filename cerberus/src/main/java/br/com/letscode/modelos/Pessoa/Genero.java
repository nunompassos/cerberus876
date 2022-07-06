package br.com.letscode.modelos.Pessoa;

import java.util.HashMap;

public enum Genero {
	MASCULINO('M'),
	FEMININO('F'),
	OUTRO('O');

	private static final class MapaInterno {
		private static final HashMap<Character, Genero> map = new HashMap<Character, Genero>();
	}

	private final char valor;

	Genero(char genero) {
		this.valor = genero;
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
		return this.name();
	}
}
