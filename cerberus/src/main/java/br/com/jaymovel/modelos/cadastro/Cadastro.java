package br.com.jaymovel.modelos.cadastro;

import java.util.Collection;
import java.util.LinkedList;

import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Cadastro {
	private final Pessoa cliente;
	private final Collection<Aluguel> alugueis = new LinkedList<>();

	Cadastro(Pessoa cliente) {
		if (cliente == null)
			throw new IllegalArgumentException("Cadastro tem que ter pessoa");
		this.cliente = cliente;
	}

	public void novoAluguel(Veiculo veiculo, int dias) {
		Aluguel novoAluguel = new Aluguel(veiculo, this.cliente, dias);
		this.alugueis.add(novoAluguel);
	}

	public Pessoa getCliente() {
		return this.cliente;
	}
}
