package br.com.jaymovel.telas;

import java.util.HashMap;
import java.util.Map;

import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.excecoes.SairDaTelaException;
import br.com.jaymovel.excecoes.VeiculoDuplicadoException;
import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.util.Formulario;

public class TelaAdmin extends Tela {
	private static final Map<Integer, String> opcoes = new HashMap<>();
	{
		opcoes.put(1, "Cadastrar veículo");
		opcoes.put(2, "Sair");
	}

	public TelaAdmin(Agencia agencia) throws JayMovelException {
		super(
				"Tela Auto Administrativa (TAA)",
				opcoes,
				true);
		Tela.agencia = agencia;
		super.iniciar();

	}

	@Override
	protected void opcao1() {
		Veiculo veiculo = Formulario.cadastrarVeiculo();
		try {
			Tela.agencia.adicionaVeiculo(veiculo);
		} catch (VeiculoDuplicadoException e) {
			this.setMensagem("Veículo já cadastrado...");
			return;
		}
		System.out.println("Veículo cadastrado com sucesso!");
	}

	@Override
	protected void opcao2() throws SairDaTelaException {
		throw new SairDaTelaException();
	}

    @Override
    protected void mostraInfo() {}
}
