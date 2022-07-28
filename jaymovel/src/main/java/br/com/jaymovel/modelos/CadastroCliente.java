package br.com.jaymovel.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

	void adicionaAluguel(Aluguel novoAluguel) {
		this.alugueis.put(novoAluguel.getId(), novoAluguel);
	}

	Aluguel removeAluguel(long idAluguel) {
		return this.alugueis.remove(idAluguel);
	}

	public boolean contem(long idAluguel) {
		return this.alugueis.containsKey(idAluguel);
	}

	public List<Aluguel> getAlugueis() {
		return Collections.unmodifiableList(new ArrayList<Aluguel>(alugueis.values()));
	}
}
