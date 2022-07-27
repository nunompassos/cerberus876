package br.com.jaymovel.modelos;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CadastroCliente {

	private final Map<Long, Aluguel> alugueis = new HashMap<>();

	public BigDecimal getDivida() {
		BigDecimal divida = BigDecimal.ZERO;
		for (Aluguel aluguel: alugueis.values()) {
			divida = divida.add(aluguel.calculaPreco());
		}
		return divida;
	}

	public void adicionaAluguel(Aluguel novoAluguel) {
		this.alugueis.put(novoAluguel.getId(), novoAluguel);
	}

	public Aluguel removeAluguel(long idAluguel) {
		return this.alugueis.remove(idAluguel);
	}

	public Map<Long, Aluguel> getAlugueis() {
		return Collections.unmodifiableMap(alugueis);
	}
}
