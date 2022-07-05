package br.com.letscode.modelos.Pessoa;

import java.util.HashMap;

public enum EstadoCivil {
	SOLTEIRO('S'),
	CASADO('C'),
	VIUVO('V'),
	DIVORCIADO('D');

	private final char valor;

	private static final class EstaticosInternos {
		private static final HashMap<Character, EstadoCivil> map = new HashMap<Character, EstadoCivil>();
	}
	
	EstadoCivil(char estado) {
		this.valor = estado;
		EstaticosInternos.map.put(estado, this);
	}

	public static EstadoCivil deChar(char estado) {
		return EstaticosInternos.map.get(estado);
	}

	@Override
	public String toString() {
		return "" + this.valor;
	}
}
