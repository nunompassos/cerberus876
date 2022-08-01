package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.excecoes.PessoaDuplicadaException;
import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.util.Formulario;

public class TelaInicial extends Tela {

	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(0, "Admin");
		opcoes.put(1, "Entrar");
		opcoes.put(2, "Cadastrar");
		opcoes.put(3, "Sair");
	}

	public TelaInicial(Agencia agencia) throws JayMovelException {
		super(
				"Tela Inicial",
				opcoes,
				true);
		Tela.agencia = agencia;
		super.iniciar();

	}

	@Override
	protected void opcao0() {
		try{
			new TelaAdmin(Tela.agencia);
		} catch(JayMovelException e){
			super.setMensagem("Erro ao exibir tela Admin.");
			return;
		}
	}

	@Override
	protected void opcao1() {
		try {
			Pessoa cliente = Formulario.entrar();
			new TelaLogada(cliente).iniciar();
		} catch (ClienteNaoCadastradoException e) {
			super.setMensagem("Cliente não encontrado.");
			return;
		}
	}

	@Override
	protected void opcao2() {
		Pessoa cliente = Formulario.cadastrarCliente();
		try {
			Tela.agencia.adicionaCliente(cliente);
		} catch (PessoaDuplicadaException e) {
			this.setMensagem("Cliente já cadastrado...");
			return;
		}
		new TelaLogada(cliente).iniciar();
	}

	@Override
	protected void opcao3() throws SairDaTelaException {
		throw new SairDaTelaException();
	}

	@Override
	protected void mostraInfo() {
	};

}
