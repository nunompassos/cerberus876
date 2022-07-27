package br.com.jaymovel.modelos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.PessoaDuplicadaException;
import br.com.jaymovel.excecoes.VeiculoDuplicadoException;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Agencia implements Serializable {

	private final Map<Integer, Pessoa> mapCliente = new HashMap<>();
	private final Map<Integer, CadastroCliente> mapCadastro = new HashMap<>();
	private final Map<Integer, Veiculo> veiculos = new HashMap<>();
	private final Map<Veiculo, Boolean> disponibilidade = new HashMap<>();

	public void adicionaCliente(Pessoa cliente) throws PessoaDuplicadaException {
		if (cliente == null)
			throw new IllegalArgumentException("Cliente não pode ser nulo!");
		if (mapCliente.containsKey(cliente.getDocumento()))
			throw new PessoaDuplicadaException("Documento já cadastrado");
		mapCliente.put(cliente.getDocumento(), cliente);
		mapCadastro.put(cliente.getDocumento(), new CadastroCliente());
	}

	public Pessoa getCliente(int documentoCliente) {
		return mapCliente.get(documentoCliente);
	}

	public void adicionaVeiculo(Veiculo veiculo) throws VeiculoDuplicadoException {
		if (this.veiculos.containsKey(veiculo.getChassi()))
			throw new VeiculoDuplicadoException("Já existe um veículo com esse chassi no acervo");
		this.veiculos.put(veiculo.getChassi(), veiculo);
		this.disponibilidade.put(veiculo, true);
	}

	public void fazAluguel(int documento, int chassi) {
		//TODO comparar esse chassi com os carros disponíveis e montar um aluguel para aquele cliente.
	}

	public void terminaAluguel(long numeroAluguel) {
		Aluguel terminado= null;
		for (CadastroCliente cadastro : mapCadastro.values()) {
			Aluguel daVez = cadastro.removeAluguel(numeroAluguel);
			if (daVez != null) {
				terminado = daVez;
				break;
			}
		}
		if (terminado == null) return;//id não encontrada
		disponibilidade.put(terminado.getVeiculo(), true);
	}

	public CadastroCliente getCadastro(int documento) {
		return mapCadastro.get(documento);
	}
}
