package br.com.jaymovel.modelos.cadastro;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.excecoes.PessoaDuplicadaException;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class Agencia {
	private final Map<Integer, Pessoa> mapDocumentoCliente = new HashMap<>();
	private final Map<Pessoa, Cadastro> mapPessoaCadstro = new HashMap<>();

	public boolean cadastraCliente (Pessoa cliente) throws PessoaDuplicadaException {
		if (cliente == null)
			throw new IllegalArgumentException("Cliente não pode ser nulo!");
		if (mapDocumentoCliente.containsKey(cliente.getDocumento()))
			throw new PessoaDuplicadaException("Documento já cadastrado");
		mapDocumentoCliente.put(cliente.getDocumento(), cliente);
		mapPessoaCadstro.put(cliente, new Cadastro(cliente));
		return true;
	}

	public void novoAluguel (int documentoCliente, Veiculo veiculo, int dias) throws ClienteNaoCadastradoException {
		Pessoa cliente = getCliente(documentoCliente);
		mapPessoaCadstro.get(cliente).adicionaAluguel(veiculo, dias);
	}

	public BigDecimal calculaDivida(int documentoCliente) throws ClienteNaoCadastradoException {
		Cadastro cadastro = mapPessoaCadstro.get(getCliente(documentoCliente));
		return cadastro.getDivida();
	}

	private Pessoa getCliente(int documentoCliente) throws ClienteNaoCadastradoException {
		Pessoa cliente = mapDocumentoCliente.get(documentoCliente);
		if (cliente == null) 
			throw new ClienteNaoCadastradoException();
		return cliente;
	}
}
