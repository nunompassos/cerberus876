package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.excecoes.VeiculoIndisponivelException;
import br.com.jaymovel.excecoes.VeiculoNaoCadastradoException;
import br.com.jaymovel.modelos.Aluguel;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.util.Formulario;

public class TelaLogada extends Tela {

	private Pessoa cliente;
	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Alugar");
		opcoes.put(2, "Finalizar aluguel");
		opcoes.put(3, "Meus aluguéis");
		opcoes.put(4, "Sair");
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
	protected void opcao2() throws SairDaTelaException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void opcao3() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void opcao4() throws SairDaTelaException {
		throw new SairDaTelaException();

	}

	@Override
	protected void mostraInfo() {

	}

}
