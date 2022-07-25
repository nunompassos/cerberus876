package br.com.jaymovel.modelos.cadastro;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import br.com.jaymovel.modelos.pessoa.Pessoa;

public class Agencia {
	private final Collection<Pessoa> clientes = new HashSet<>();
	private final Map<Integer, Pessoa> mapDocumentoCliente = new HashMap<>();
	private final Map<Pessoa, Cadastro> MapPessoaCadstro = new HashMap<>();


}
