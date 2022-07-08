package br.com.letscode;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import br.com.letscode.modelos.Banco;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.modelos.pessoa.PessoaFisica;
import br.com.letscode.telas.Tela;
import br.com.letscode.util.Console;

public abstract class Formulario {

	public static Pessoa entrar() {
		System.out.println("Informe seu documento: ");
		int documento = -1;
		documento = Console.lerInt(0, Integer.MAX_VALUE);
		return Banco.selecionada.getCliente(documento);
	}

	public static PessoaFisica cadastrarClientePf() {
		Console.limparConsole();
		System.out.println();
		Console.printaCentro("Informe os dados do cliente");
		Console.printaCentro("(escreva CANCELAR para sair)");
		System.out.println();
		System.out.printf("%-10s", "Nome :");
		String nome = Tela.sc.nextLine();
		System.out.printf("%-15s", "CPF :");
		int documento = -1;
		while (true) {
			documento = Console.lerInt(0, Integer.MAX_VALUE);
			if (Pessoa.documentos.contains(documento)) {
				System.out.println("CPF já cadastrado...");
				continue;
			}
			break;
		}
		System.out.printf("%-15s", "Endereço :");
		String endereco = Tela.sc.nextLine();
		System.out.printf("%-15s", "Telefone :");
		String telefone = Tela.sc.nextLine();
		System.out.printf("%-15s", "Nascimento :");
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
}
