package br.com.jaymovel.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import br.com.jaymovel.excecoes.ClienteNaoCadastradoException;
import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.Aluguel;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.TipoVeiculo;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.telas.Tela;

public abstract class Formulario {

	public static Pessoa entrar() throws ClienteNaoCadastradoException {
		System.out.println("Informe seu documento: ");
		int documento = -1;
		documento = Console.lerInt(0, Integer.MAX_VALUE);
		return Tela.getAgencia().getCliente(documento);
	}

	public static void meusDados(Pessoa cliente) {
		Console.limparConsole();
		if (cliente instanceof PessoaFisica)
			meusDados((PessoaFisica) cliente);
		if (cliente instanceof PessoaJuridica)
			meusDados((PessoaJuridica) cliente);
		System.out.println(System.lineSeparator() + "Aperte ENTER para continuar...");
		Console.sc.nextLine();
	}

	public static void meusDados(PessoaFisica cliente) {
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getDocumento());
		System.out.println("Endereco: " + cliente.getEndereco());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Idade: " + cliente.getIdade());
	}

	public static void meusDados(PessoaJuridica cliente) {
		System.out.println("Razão social: " + cliente.getNome());
		System.out.println("CNPJ: " + cliente.getDocumento());
		System.out.println("Endereco: " + cliente.getEndereco());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Responsável: " + cliente.getResponsavel().getNome());
	}

	public static Pessoa cadastrarCliente() {
		while (true) {
			Console.limparConsole();
			System.out.println();
			System.out.println("Pessoa física (PF) ou pessoa jurídica (PJ) ?");
			System.out.println();
			String escolha = Console.sc.nextLine();
			Pessoa novoCliente = null;
			if (escolha.toLowerCase().equals("pj") ||
					escolha.toLowerCase().equals("pessoa juridica") ||
					escolha.toLowerCase().equals("juridica"))
				novoCliente = cadastrarClientePj();
			if (escolha.toLowerCase().equals("pf") ||
					escolha.toLowerCase().equals("fisica") ||
					escolha.toLowerCase().equals("pessoa fisica"))
				novoCliente = cadastrarClientePf();
			if (novoCliente == null)
				continue;
			return novoCliente;
		}

	}

	public static PessoaFisica cadastrarClientePf() {
		Console.limparConsole();
		System.out.println();
		Console.printaCentro("Informe os dados do cliente");
		// Console.printaCentro("(escreva CANCELAR para sair)");
		System.out.println();
		System.out.printf("%-30s", "Nome :");
		String nome = Console.sc.nextLine();
		System.out.printf("%-30s", "CPF :");
		int documento = -1;
		while (true) {
			documento = Console.lerInt(0, Integer.MAX_VALUE);
			try {
				Tela.getAgencia().getCliente(documento);
				System.out.println("CPF já cadastrado...");
			} catch (ClienteNaoCadastradoException e) {
				break;
			}
		}
		System.out.printf("%-30s", "Endereço :");
		String endereco = Console.sc.nextLine();
		System.out.printf("%-30s", "Telefone :");
		String telefone = Console.sc.nextLine();
		System.out.printf("%-30s", "Nascimento (AAAA-MM-DD):");
		String nascimento = "";
		while (true) {
			nascimento = Console.sc.nextLine();
			try {
				LocalDate.parse(nascimento);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida...");
			}
		}

		PessoaFisica novoCliente = new PessoaFisica(nome, documento, endereco, telefone, nascimento);
		return novoCliente;
	}

	public static PessoaJuridica cadastrarClientePj() {
		Console.limparConsole();
		System.out.println();
		Console.printaCentro("Informe os dados da empresa");
		// Console.printaCentro("(escreva CANCELAR para sair)");
		System.out.println();
		System.out.printf("%-30s", "Razão social :");
		String nome = Console.sc.nextLine();
		System.out.printf("%-30s", "CNPJ :");
		int documento = -1;
		while (true) {
			documento = Console.lerInt(0, Integer.MAX_VALUE);
			try {
				Tela.getAgencia().getCliente(documento);
				System.out.println("CNPJ já cadastrado...");
			} catch (ClienteNaoCadastradoException e) {
				break;
			}
		}
		System.out.printf("%-30s", "Endereço :");
		String endereco = Console.sc.nextLine();
		System.out.printf("%-30s", "Telefone :");
		String telefone = Console.sc.nextLine();
		PessoaFisica dono = null;
		while (true) {
			System.out.printf("%-30s", "CPF do dono:");
			int cpfDono = Console.lerInt(0, Integer.MAX_VALUE);
			try {
				dono = (PessoaFisica) Tela.agencia.getCliente(cpfDono);
			} catch (ClienteNaoCadastradoException e) {
				System.out.println("Dono não encontrado. Cadastrar dono (s/n)?");
				if (Console.sc.nextLine().toLowerCase().equals("s")) {
					dono = cadastrarClientePf();
					break;
				}
			}
		}
		PessoaJuridica novoCliente = new PessoaJuridica(nome, documento, endereco, telefone, dono);
		return novoCliente;
	}

	public static Veiculo escolherVeiculoDisponivel() {
		Console.limparConsole();
		List<Veiculo> disponiveis = Tela.agencia.getVeiculosDisponiveis();
		if (disponiveis.isEmpty())
			return null; // Sem carros disponíveis

		int i = 0;
		for (Veiculo veiculo : disponiveis) {
			System.out.printf("%d: %s%n", ++i, veiculo);
		}
		int escolha = Console.lerInt(1, disponiveis.size());

		return disponiveis.get(escolha - 1);
	}

	public static int escolherNumeroDeDias() {
		Console.printaCentro("Por quantos dias você quer alugar?");
		Console.printaCentro("(Máximo de " + Agencia.MAXIMO_DIAS_POR_LOCACAO + " dias por locação)");
		return Console.lerInt(1, Agencia.MAXIMO_DIAS_POR_LOCACAO);

	}

	public static Veiculo cadastrarVeiculo() {
		Console.limparConsole();
		System.out.println();
		Console.printaCentro("Informe os dados do veículo");
		System.out.println();

		System.out.printf("%-30s", "Qual o tipo do veículo?");
		System.out.println("Pequeno (P) / Medio (M) / SUV (S)");
		TipoVeiculo tipo = null;
		do {
			String escolha = Console.sc.nextLine();
			if (escolha.toLowerCase().equals("p") ||
					escolha.toLowerCase().equals("pequeno")) {
				tipo = TipoVeiculo.PEQUENO;
			}
			else if (escolha.toLowerCase().equals("m") ||
					escolha.toLowerCase().equals("medio")) {
				tipo = TipoVeiculo.MEDIO;
			}
			else if (escolha.toLowerCase().equals("s") ||
					escolha.toLowerCase().equals("suv")) {
				tipo = TipoVeiculo.SUV;
			} else {
				System.out.print("\rTipo inválido...");
			}
		} while (tipo == null);

		System.out.printf("%-30s", "Chassi:");
		int chassi = Console.lerInt(0, Integer.MAX_VALUE);
		System.out.printf("%-30s", "Marca:");
		String marca = Console.sc.nextLine();
		System.out.printf("%-30s", "Modelo:");
		String modelo = Console.sc.nextLine();
		//Tem carro que é lançado com modelo do ano que vem
		System.out.printf("%-30s", "Ano:");
		int ano = Console.lerInt(1900, LocalDate.now().getYear() + 1);
		System.out.printf("%-30s", "Cor:");
		String cor = Console.sc.nextLine();

		Veiculo novoVeiculo = new Veiculo(tipo, chassi, marca, modelo, ano, cor);
		return novoVeiculo;
	}

	public static boolean confimaAluguel(Aluguel novoAluguel) {
		Console.limparConsole();
		Console.printaCentro(novoAluguel.getVeiculo().toString());
		System.out.println();

		Console.printaCentro("Período: " + novoAluguel.getDias() + " dias");
		System.out.println();

		Console.printaCentro(String.format("  Valor do aluguel: R$ %.2f  ", novoAluguel.calculaPreco()), '$');
		System.out.println();

		Console.printaCentro("Confirma operação (s/n) ?");
		String escolha = Console.sc.nextLine().toLowerCase();

		return (escolha.equals("s") ||
				escolha.equals("sim"));
	}

	public static Aluguel selecionaAluguelParaFinalizar(Pessoa cliente) throws ClienteNaoCadastradoException {
		List<Aluguel> alugueis = mostraRetornaAlugueisDoCliente(cliente);
		if (alugueis.isEmpty()) {
			return null;
		}
		Console.printaCentro("Escolha um aluguel para finalizar");

		int escolha = Console.lerInt(1, alugueis.size());

		return alugueis.get(escolha - 1);
	}

	public static boolean confirmaFinalizacaoAluguel(Aluguel finalizando) {
		Console.limparConsole();
		Console.printaCentro(finalizando.getVeiculo().toString());
		System.out.println();

		Console.printaCentro("Período: " + finalizando.getDias() + " dias");
		System.out.println();

		Console.printaCentro(String.format("  Valor do aluguel: R$ %.2f  ", finalizando.calculaPreco()), '$');
		System.out.println();

		Console.printaCentro("Confirmar término do aluguel (s/n)?");
		String resposta = Console.sc.nextLine().toLowerCase();
		return (resposta.equals("s") ||
				resposta.equals("sim"));
	}

	public static List<Aluguel> mostraRetornaAlugueisDoCliente(Pessoa cliente) throws ClienteNaoCadastradoException {
		Console.limparConsole();
		List<Aluguel> alugueis = Tela.agencia.getCadastro(cliente).getAlugueis();

		// mostrar os aluguéis
		int i = 1;
		for (Aluguel daVez : alugueis) {
			System.out.printf(
					"%d: %s, %d dias, R$%.2f%n",
					i++,
					daVez.getVeiculo(),
					daVez.getDias().intValue(),
					daVez.calculaPreco());
		}
		System.out.println();

		return alugueis;
	}

	public static void mostraAlugueisDoCliente(Pessoa cliente) throws ClienteNaoCadastradoException {
		mostraRetornaAlugueisDoCliente(cliente);
		Console.printaCentro("Aperte ENTER para continuar...");
		Console.sc.nextLine();
	}

}