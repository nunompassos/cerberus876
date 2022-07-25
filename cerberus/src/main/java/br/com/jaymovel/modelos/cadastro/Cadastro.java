package br.com.jaymovel.modelos.cadastro;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Cadastro {
	private final Pessoa cliente;
	private final Collection<Aluguel> alugueis = new LinkedList<>();

	Cadastro(Pessoa cliente) {
		if (cliente == null)
			throw new IllegalArgumentException("Cadastro tem que ter cliente");
		this.cliente = cliente;
	}

	public BigDecimal getDivida() {
		BigDecimal divida = BigDecimal.ZERO;
		for (Aluguel aluguel: alugueis) {
			divida = divida.add(aluguel.calculaPreco());
		}
		return divida;
	}

	public void adicionaAluguel(Veiculo veiculo, int dias) {
		Aluguel novoAluguel = new Aluguel(veiculo, this.cliente, dias);
		this.alugueis.add(novoAluguel);
	}

	public Collection<Aluguel> getAlugueis() {
		return Collections.unmodifiableCollection(alugueis);
	}

	public Pessoa getCliente() {
		return this.cliente;
	}
}
