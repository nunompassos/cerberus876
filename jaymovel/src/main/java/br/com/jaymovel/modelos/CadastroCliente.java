package br.com.jaymovel.modelos;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class CadastroCliente {

	private final Collection<Aluguel> alugueis = new LinkedList<>();

	public BigDecimal getDivida() {
		BigDecimal divida = BigDecimal.ZERO;
		for (Aluguel aluguel: alugueis) {
			divida = divida.add(aluguel.calculaPreco());
		}
		return divida;
	}

	public void adicionaAluguel(Aluguel novoAluguel) {
		this.alugueis.add(novoAluguel);
	}

	public void removeAluguel(Aluguel aluguel) {
		this.alugueis.remove(aluguel);
	}

	public Collection<Aluguel> getAlugueis() {
		return Collections.unmodifiableCollection(alugueis);
	}
}
