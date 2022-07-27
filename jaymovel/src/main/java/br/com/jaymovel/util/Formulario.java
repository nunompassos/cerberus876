package br.com.jaymovel.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.Aluguel;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.telas.Tela;

public abstract class Formulario {

	public static Pessoa entrar() {
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
		System.out.println("\nAperte ENTER para continuar...");
		Tela.sc.nextLine();
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
			String escolha = Tela.sc.nextLine();
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
		String nome = Tela.sc.nextLine();
		System.out.printf("%-30s", "CPF :");
		int documento = -1;
		while (true) {
			documento = Console.lerInt(0, Integer.MAX_VALUE);
			if (Tela.getAgencia().getCliente(documento) != null) {
				System.out.println("CPF já cadastrado...");
				continue;
			}
			break;
		}
		System.out.printf("%-30s", "Endereço :");
		String endereco = Tela.sc.nextLine();
		System.out.printf("%-30s", "Telefone :");
		String telefone = Tela.sc.nextLine();
		System.out.printf("%-30s", "Nascimento (AAAA-MM-DD):");
		String nascimento = "";
		while (true) {
			nascimento = Tela.sc.nextLine();
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
		String nome = Tela.sc.nextLine();
		System.out.printf("%-30s", "CNPJ :");
		int documento = -1;
		while (true) {
			documento = Console.lerInt(0, Integer.MAX_VALUE);
			if (Tela.getAgencia().getCliente(documento) != null) {
				System.out.println("CNPJ já cadastrado...");
				continue;
			}
			break;
		}
		System.out.printf("%-30s", "Endereço :");
		String endereco = Tela.sc.nextLine();
		System.out.printf("%-30s", "Telefone :");
		String telefone = Tela.sc.nextLine();
		PessoaFisica dono = null;
		while (true) {
			System.out.printf("%-30s", "CPF do dono:");
			int cpfDono = Console.lerInt(0, Integer.MAX_VALUE);
			dono = (PessoaFisica) Tela.agencia.getCliente(cpfDono);

			if (dono == null) {
				System.out.println("Dono não encontrado. Cadastrar dono (s/n)?");
				if (Tela.sc.nextLine().toLowerCase().equals("s")) {
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

		return disponiveis.get(escolha);
	}

	public static int escolherNumeroDeDias() {
		Console.printaCentro("Por quantos dias você quer alugar?");
		Console.printaCentro("(Máximo de " + Agencia.MAXIMO_DIAS_POR_LOCACAO + " dias por locação)");
		return Console.lerInt(1, Agencia.MAXIMO_DIAS_POR_LOCACAO);

	}

	public static boolean confimaAluguel(Aluguel novoAluguel) {
		Console.limparConsole();
		System.out.println(novoAluguel.getVeiculo());
		Console.printaCentro("Período: " + novoAluguel.getDias() + " dias");
		Console.printaCentro(String.format("Valor do aluguel: %.2f", novoAluguel.calculaPreco()), '$');
		System.out.println();
		Console.printaCentro("Confirma operação (s/n) ?");
		String escolha = Tela.sc.nextLine();
		return (escolha.toLowerCase().equals("s") ||
				escolha.toLowerCase().equals("sim"));
	}

}