package br.com.letscode.telas;

import br.com.letscode.excecoes.SairDaTelaException;
import br.com.letscode.modelos.Agencia;
import br.com.letscode.modelos.Banco;
import br.com.letscode.modelos.conta.ContaCorrente;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.util.Console;

public class TelaLogadaContaCorrente extends Tela {

	private ContaCorrente conta;
	private Pessoa cliente;
	private Agencia agencia = Banco.selecionada;

	public TelaLogadaContaCorrente(Pessoa cliente) {
		super(
				"Tela Logada",
				new String[] { "Saldo", "Transferir", "Sair" });
		this.cliente = cliente;
		this.conta = (ContaCorrente) Banco.selecionada.getContas(cliente)[0];
	}

	@Override
	protected void opcao1() {}

	@Override
	protected void opcao2() {
	}

	@Override
	protected void opcao3() {
		throw new SairDaTelaException();
	}

	@Override
	protected void opcao4() {
		opcao3();
	}

	@Override
	protected void opcao5() {
		opcao3();
	}

	@Override
	protected void opcao6() {
		opcao3();
	}

	@Override
	protected void opcao7() {
		opcao3();
	}

	@Override
	protected void opcao8() {
		opcao3();
	}

	@Override
	protected void mostraInfo() {
		Console.printaCentro(String.format(
			"SALDO: %s\tDÍVIDA: %s\tLIMITE: %s",
			conta.getSaldoFormatado(),
			conta.getDividaFormatada(),
			conta.getLimiteFormatado()
		));
	};

}
