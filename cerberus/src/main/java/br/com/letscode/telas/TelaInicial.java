package br.com.letscode.telas;

import br.com.letscode.Formulario;
import br.com.letscode.excecoes.BancoJayException;
import br.com.letscode.excecoes.PessoaDuplicadaException;
import br.com.letscode.excecoes.SairDaTelaException;
import br.com.letscode.modelos.pessoa.Pessoa;

public class TelaInicial extends Tela {

	public TelaInicial() throws BancoJayException {
		super(
			"Tela Inicial",
			new String[] {"Entrar", "Cadastrar", "Sair"}
			);
			super.iniciar();
	}

	@Override
	protected void opcao1() {
		Pessoa cliente = Formulario.entrar();
		if (cliente == null) {
			super.setMensagem("Cliente não encontrado.");
			return;
		}
		new TelaLogadaContaCorrente(cliente).iniciar();
	}
	@Override
	protected void opcao2() {
		try {
			Pessoa cliente = Formulario.cadastrarCliente();
			new TelaLogadaContaCorrente(cliente).iniciar();
		}
		catch (PessoaDuplicadaException e) {
			super.setMensagem("ERRO: " + e);
		}
	}
	@Override
	protected void opcao3() throws SairDaTelaException {throw new SairDaTelaException();}
	@Override
	protected void opcao4() throws SairDaTelaException {opcao3();}
	@Override
	protected void opcao5() throws SairDaTelaException {opcao3();}
	@Override
	protected void opcao6() throws SairDaTelaException {opcao3();}
	@Override
	protected void opcao7() throws SairDaTelaException {opcao3();}
	@Override
	protected void opcao8() throws SairDaTelaException {opcao3();}
	@Override
	protected void mostraInfo() {};
	
}
