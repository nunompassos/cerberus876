package br.com.jaymovel.modelos.cadastro;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.enums.TipoVeiculo;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Aluguel {

	public static final Map<TipoVeiculo, BigDecimal> precos = new HashMap<>();
	{
		precos.put(TipoVeiculo.PEQUENO, BigDecimal.valueOf(12000, 2));
		precos.put(TipoVeiculo.MEDIO, BigDecimal.valueOf(18000, 2));
		precos.put(TipoVeiculo.SUV, BigDecimal.valueOf(25000, 2));
	}

	private Veiculo veiculo;
	private Pessoa cliente;
	private BigDecimal dias;

	public Aluguel(Veiculo veiculo, Pessoa cliente, int dias) {
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dias = BigDecimal.valueOf(dias);
	}

	private BigDecimal calculaDesconto() {
		if (cliente instanceof PessoaFisica && dias.intValue() > 5)
			return BigDecimal.valueOf(0.95);
		else if (cliente instanceof PessoaJuridica && dias.intValue() > 3)
			return BigDecimal.valueOf(0.90);
		return BigDecimal.ONE;
	}

	public BigDecimal calculaPreco() {
		return precos.get(veiculo.getTipo()).multiply(dias).multiply(calculaDesconto());
	}
}
