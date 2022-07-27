package br.com.jaymovel.modelos;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.excecoes.PessoaDuplicadaException;
import br.com.jaymovel.excecoes.VeiculoDuplicadoException;
import br.com.jaymovel.excecoes.VeiculoIndisponivelException;
import br.com.jaymovel.excecoes.VeiculoNaoCadastradoException;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Agencia implements Serializable {

	public static final int MAXIMO_DIAS_POR_LOCACAO = 30;
	private final Map<Integer, Pessoa> clientes = new HashMap<>();
	private final Map<Pessoa, CadastroCliente> cadastros = new HashMap<>();
	private final Map<Integer, Veiculo> veiculos = new HashMap<>();
	private final Map<Veiculo, Boolean> disponibilidade = new HashMap<>();

	public void adicionaCliente(Pessoa cliente) throws PessoaDuplicadaException {
		if (cliente == null)
			throw new IllegalArgumentException("Cliente não pode ser nulo!");
		if (clientes.containsKey(cliente.getDocumento()))
			throw new PessoaDuplicadaException("Documento já cadastrado");
		clientes.put(cliente.getDocumento(), cliente);
		cadastros.put(cliente, new CadastroCliente());
	}

	public Pessoa getCliente(int documentoCliente) {
		return clientes.get(documentoCliente);
	}

	public void adicionaVeiculo(Veiculo veiculo) throws VeiculoDuplicadoException {
		if (this.veiculos.containsKey(veiculo.getChassi()))
			throw new VeiculoDuplicadoException("Já existe um veículo com esse chassi no acervo");
		this.veiculos.put(veiculo.getChassi(), veiculo);
		this.disponibilidade.put(veiculo, true);
	}

	public void fazAluguel(Aluguel novoAluguel) throws ClienteNaoCadastradoException, VeiculoNaoCadastradoException, VeiculoIndisponivelException {
		if (!cadastros.containsKey(novoAluguel.getCliente())) {
			throw new ClienteNaoCadastradoException();
		}
		if (!veiculos.containsKey(novoAluguel.getVeiculo().getChassi())) {
			throw new VeiculoNaoCadastradoException();
		}
		if (!disponibilidade.get(novoAluguel.getVeiculo())) {
			throw new VeiculoIndisponivelException();
		}
		cadastros.get(novoAluguel.getCliente()).adicionaAluguel(novoAluguel);
		disponibilidade.put(novoAluguel.getVeiculo(), false);
	}

	public void terminaAluguel(long numeroAluguel) {
		Aluguel terminado = null;
		for (CadastroCliente cadastro : cadastros.values()) {
			Aluguel daVez = cadastro.removeAluguel(numeroAluguel);
			if (daVez != null) {
				terminado = daVez;
				break;
			}
		}
		if (terminado == null)
			return;// id não encontrada
		disponibilidade.put(terminado.getVeiculo(), true);
	}

	public List<Veiculo> getVeiculosDisponiveis() {
		return Collections.unmodifiableList(
				veiculos
						.values()
						.stream()
						.filter(this.disponibilidade::get)
						.collect(Collectors.toList()));
	}
}
