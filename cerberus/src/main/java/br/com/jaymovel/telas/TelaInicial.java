package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.Formulario;
import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.excecoes.PessoaDuplicadaException;
import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.modelos.pessoa.Pessoa;

public class TelaInicial extends Tela {

	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Entrar");
		opcoes.put(2, "Cadastrar");
		opcoes.put(3, "Sair");
	}

	public TelaInicial() throws JayMovelException {
		super(
				"Tela Inicial",
				opcoes,
				true);
		super.iniciar();

	}

	@Override
	protected void opcao1() {
		Pessoa cliente = Formulario.entrar();
		if (cliente == null) {
			super.setMensagem("Cliente não encontrado.");
			return;
		}
		new TelaLogada(cliente).iniciar();
	}

	@Override
	protected void opcao2() {
		try {
			Pessoa cliente = Formulario.cadastrarCliente();
			new TelaLogada(cliente).iniciar();
		} catch (PessoaDuplicadaException e) {
			super.setMensagem("ERRO: " + e);
		}
	}

	@Override
	protected void opcao3() throws SairDaTelaException {
		throw new SairDaTelaException();
	}

	@Override
	protected void opcao4() throws SairDaTelaException {
		opcao3();
	}

	@Override
	protected void opcao5() throws SairDaTelaException {
		opcao3();
	}

	@Override
	protected void opcao6() throws SairDaTelaException {
		opcao3();
	}

	@Override
	protected void opcao7() throws SairDaTelaException {
		opcao3();
	}

	@Override
	protected void opcao8() throws SairDaTelaException {
		opcao3();
	}

	@Override
	protected void mostraInfo() {
	};

}
