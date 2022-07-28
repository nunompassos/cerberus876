package br.com.jaymovel.telas;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.excecoes.VeiculoIndisponivelException;
import br.com.jaymovel.excecoes.VeiculoNaoCadastradoException;
import br.com.jaymovel.modelos.Aluguel;
import br.com.jaymovel.modelos.CadastroCliente;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.util.Console;
import br.com.jaymovel.util.Formulario;

public class TelaLogada extends Tela {

	private Pessoa cliente;
	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Alugar");
		opcoes.put(2, "Finalizar aluguel");
		opcoes.put(3, "Meus aluguéis");
		opcoes.put(4, "Meus Dados");
		opcoes.put(5, "Sair");
	}

	TelaLogada(Pessoa cliente) {
		super("Tela Logada", opcoes, false);
		this.cliente = cliente;
	}

	@Override
	protected void opcao1() throws SairDaTelaException {
		Veiculo escolhido = Formulario.escolherVeiculoDisponivel();
		if (escolhido == null) {
			this.setMensagem("Sem veículos disponíveis");
			return;
		}
		int dias = Formulario.escolherNumeroDeDias();
		Aluguel novoAluguel = new Aluguel(escolhido, cliente, dias);
		if (Formulario.confimaAluguel(novoAluguel)) {
			try {
				Tela.agencia.fazAluguel(novoAluguel);
				this.setMensagem("Aluguel realizado com sucesso! Código: " + novoAluguel.getId());
			} catch (VeiculoNaoCadastradoException | ClienteNaoCadastradoException e) {
				this.setMensagem("Cliente ou veículo não cadastrados...");
			} catch (VeiculoIndisponivelException e) {
				this.setMensagem("Veículo selecionado está indisponível...");
			}
		} else {
			this.setMensagem("Operação cancelada pelo usuário...");
		}
	}

	@Override
	protected void opcao2() {
		Aluguel finalizando;
		try {
			finalizando = Formulario.selecionaAluguelParaFinalizar(cliente);
			if (Formulario.confirmaFinalizacaoAluguel(finalizando)) {
				Tela.agencia.terminaAluguel(finalizando.getId());
				this.setMensagem("Aluguel com código " + finalizando.getId() + " finalizado com sucesso!");
			} else {
				this.setMensagem("Operação cancelada pelo usuário");
			}
		} catch (ClienteNaoCadastradoException e) {
			this.setMensagem("Problema com o cadastro do cliente");
		}

	}

	@Override
	protected void opcao3() {
		try {
			Formulario.mostraAlugueisDoCliente(cliente);
		} catch (ClienteNaoCadastradoException e) {
			this.setMensagem("Problema com o cadastro do cliente");
		}
	}

	@Override
	protected void opcao4() {
		Formulario.meusDados(cliente);
	}

	@Override
	protected void opcao5() throws SairDaTelaException {
		throw new SairDaTelaException();

	}

	@Override
	protected void mostraInfo() {
		int numeroAlugueis;
		BigDecimal divida;
		try {
			CadastroCliente cadstro = Tela.agencia.getCadastro(cliente);
			numeroAlugueis = cadstro.getAlugueis().size();
			divida = cadstro.getDivida();
		} catch (ClienteNaoCadastradoException e) {
			Console.printaCentro("CLIENTE NAO CADASTRADO");
			return;
		}
		Console.printaCentro(cliente.getNome());
		Console.printaCentro(String.valueOf(cliente.getDocumento()));
		System.out.println();
		Console.printaCentro(String.format("Dívida: R$%.2f", divida));
		Console.printaCentro(String.format("Você tem %d aluguéis ativos", numeroAlugueis));
	}

}
