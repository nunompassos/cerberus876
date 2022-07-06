package br.com.letscode.modelos.Conta;

import java.util.HashMap;
import java.util.Random;

public enum PerfilInvestidor {
	CONSERVADOR(
			-0.1,
			0.2,
			'C'),
	MODERADO(
			-0.3,
			0.5,
			'M'),
	AGRESSIVO(
			-0.8,
			1.0,
			'A');

	private static final class MapaInterno {
		private static final HashMap<Character, PerfilInvestidor> map = new HashMap<Character, PerfilInvestidor>();
	}

	private static final Random random = new Random();
	private final double min;
	private final double max;

	PerfilInvestidor(double min, double max, char perfil) {
		this.min = min;
		this.max = max;
		MapaInterno.map.put(perfil, this);
	}

	public static PerfilInvestidor deChar(char perfil) {
		return MapaInterno.map.get(perfil);
	}

	public double getVariacao() {
		return min + PerfilInvestidor.random.nextDouble() * (max - min);
	}

	@Override
	public String toString() {
		return this.name();
	}

}
