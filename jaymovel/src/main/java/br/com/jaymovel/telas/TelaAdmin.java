package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.excecoes.VeiculoDuplicadoException;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.util.Formulario;

public class TelaAdmin extends Tela {
	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Cadastrar veículo");
		opcoes.put(2, "Sair");
	}

	public TelaAdmin() {
		super(
				"Tela Auto Administrativa (TAA)",
				opcoes,
				true);
		super.iniciar();
	}

	@Override
	protected void opcao1() {
		Veiculo veiculo = Formulario.cadastrarVeiculo();
		if (!Formulario.confirmaCadastroVeiculo(veiculo)) {
			this.setMensagem("Operação cancelada pelo usuário");
			return;
		}
		try {
			Tela.agencia.adicionaVeiculo(veiculo);
		} catch (VeiculoDuplicadoException e) {
			this.setMensagem("ERRO: Veículo com mesmo chassi já cadastrado...");
			return;
		}
		this.setMensagem("Veículo cadastrado com sucesso!");
	}

	@Override
	protected void opcao2() throws SairDaTelaException {
		throw new SairDaTelaException();
	}
}
