package br.com.jaymovel.modelos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.TipoVeiculo;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Aluguel {

	public static final Map<TipoVeiculo, BigDecimal> precos = new HashMap<>();
	{
		precos.put(TipoVeiculo.PEQUENO, BigDecimal.valueOf(10000, 2));
		precos.put(TipoVeiculo.MEDIO, BigDecimal.valueOf(15000, 2));
		precos.put(TipoVeiculo.SUV, BigDecimal.valueOf(20000, 2));
	}
	private static long IDS;

	private Veiculo veiculo;
	private Pessoa cliente;
	private BigDecimal dias;
	private final long id;

	public Aluguel(Veiculo veiculo, Pessoa cliente, int dias) {
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dias = BigDecimal.valueOf(dias);
		this.id = IDS;
		IDS++;
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

	public long getId() {
		return id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public BigDecimal getDias() {
		return dias;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Aluguel)) return false;
		return this.id == ((Aluguel) obj).id;
	}

	@Override
	public int hashCode() {
		return (int) this.id;
	}
}
