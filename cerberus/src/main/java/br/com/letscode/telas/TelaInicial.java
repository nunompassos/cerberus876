package br.com.letscode.telas;

import br.com.letscode.Formulario;
import br.com.letscode.excecoes.SairDaTelaException;
import br.com.letscode.modelos.Agencia;
import br.com.letscode.modelos.Banco;
import br.com.letscode.modelos.conta.Conta;
import br.com.letscode.modelos.conta.ContaCorrente;
import br.com.letscode.modelos.pessoa.Pessoa;

public class TelaInicial extends Tela {

	public TelaInicial() {
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
			System.out.println("Cliente não encontrado. Aperte ENTER para continuar...");
			Tela.sc.nextLine();
			return;
		}
		new TelaLogadaContaCorrente(cliente).iniciar();
	}
	@Override
	protected void opcao2() {
		Pessoa cliente = Formulario.cadastrarClientePf();
		new TelaLogadaContaCorrente(cliente).iniciar();
	}
	@Override
	protected void opcao3() {throw new SairDaTelaException();}
	@Override
	protected void opcao4() {opcao3();}
	@Override
	protected void opcao5() {opcao3();}
	@Override
	protected void opcao6() {opcao3();}
	@Override
	protected void opcao7() {opcao3();}
	@Override
	protected void opcao8() {opcao3();}
	@Override
	protected void mostraInfo() {};
	
}
