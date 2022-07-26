package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.modelos.pessoa.Pessoa;

public class TelaLogada extends Tela {

	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Alugar");
		opcoes.put(2, "Pagar");
		opcoes.put(3, "Sair");
	}

	TelaLogada(Pessoa cliente) {
		super("Tela Logada", opcoes, false);
		//TODO Auto-generated constructor stub
	}

	@Override
	protected void opcao1() throws SairDaTelaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void opcao2() throws SairDaTelaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void opcao3() throws SairDaTelaException {
		throw new SairDaTelaException();
		
	}

	@Override
	protected void opcao4() {}

	@Override
	protected void opcao5() {}

	@Override
	protected void opcao6() {}

	@Override
	protected void opcao7() {}

	@Override
	protected void opcao8() {}

	@Override
	protected void mostraInfo() {

	}
	
}
