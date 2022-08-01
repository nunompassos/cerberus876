package br.com.jaymovel;

import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.TipoVeiculo;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.telas.TelaInicial;

public class App {
	public static void main(String[] args) throws JayMovelException {

		Agencia a = new Agencia();

		Pessoa ze = new PessoaFisica(
				"Zé da Silva",
				123,
				"Rua da Goiaba, 420",
				"(66) 6666-6666",
				"2000-01-01");
		a.adicionaCliente(ze);

		a.adicionaCliente(new PessoaJuridica(
				"Sandubas",
				456,
				"endereco",
				"telefone",
				(PessoaFisica) ze));

		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.PEQUENO,
				1,
				"Suziki",
				"SRAD",
				2021,
				"Vermelha"));
		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.PEQUENO,
				2,
				"Suziki",
				"GSX-S750ZA",
				2022,
				"Azul"));
		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.PEQUENO,
				3,
				"Cherry",
				"QQ",
				2019,
				"Branco"));
		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.MEDIO,
				4,
				"Renault",
				"Clio",
				2017,
				"Prata"));
		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.PEQUENO,
				5,
				"Chevrolet",
				"Celta",
				2012,
				"Preto"));
		a.adicionaVeiculo(new Veiculo(
				TipoVeiculo.SUV,
				6,
				"Dodge",
				"Ram",
				2021,
				"Bege"));

		new TelaInicial(a);
	}
}