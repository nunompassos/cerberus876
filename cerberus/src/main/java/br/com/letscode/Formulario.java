package br.com.letscode;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import br.com.letscode.excecoes.PessoaDuplicadaException;
import br.com.letscode.modelos.Banco;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.modelos.pessoa.PessoaFisica;
import br.com.letscode.modelos.pessoa.PessoaJuridica;
import br.com.letscode.telas.Tela;
import br.com.letscode.util.Console;

public abstract class Formulario {

	public static Pessoa entrar() {
		System.out.println("Informe seu documento: ");
		int documento = -1;
		documento = Console.lerInt(0, Integer.MAX_VALUE);
		return Banco.selecionada.getCliente(documento);
	}

	public static Pessoa cadastrarCliente() throws PessoaDuplicadaException{
		while (true) {
			Console.limparConsole();
			System.out.println();
			System.out.println("Pessoa física (PF) ou pessoa jurídica (PJ) ?");
			System.out.println();
			String escolha = Tela.sc.nextLine();
			if (escolha.toLowerCase() == "pj" || escolha.toLowerCase() == "pessoa juridica") return cadastrarClientePj();
			if (escolha.toLowerCase() == "pf" || escolha.toLowerCase() == "pessoa fisica") return cadastrarClientePf();
		}

	}
	public static PessoaFisica cadastrarClientePf() throws PessoaDuplicadaException{
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
			if (Pessoa.documentos.contains(documento)) {
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
		Banco.selecionada.cadastrarCliente(novoCliente);
		return novoCliente;
	}
	public static PessoaJuridica cadastrarClientePj() throws PessoaDuplicadaException{
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
			if (Pessoa.documentos.contains(documento)) {
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
			try {
				dono = (PessoaFisica) Banco.selecionada.getCliente(cpfDono);
				if (dono == null)
					throw new ClassCastException();
				break;
			} catch (ClassCastException e) {
				System.out.println("Dono não encontrado. Cadastrar dono (s/n)?");
				if (Tela.sc.nextLine().toLowerCase() == "s") {
					dono = cadastrarClientePf();
					break;
				}
			}
		}

		PessoaJuridica novoCliente = new PessoaJuridica(nome, documento, endereco, telefone, dono);
		Banco.selecionada.cadastrarCliente(novoCliente);
		return novoCliente;
	}
}