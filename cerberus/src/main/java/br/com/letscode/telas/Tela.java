package br.com.letscode.telas;

import java.util.Scanner;

import br.com.letscode.excecoes.SairDaTelaException;
import br.com.letscode.util.Console;

// public class Tela {
public abstract class Tela {

	public static Scanner sc = new Scanner(System.in);
	protected String[] opcoes = { "Entrar", "Cadastrar", "Sair", "Coisa", "Trem" };
	protected String nome = "Tela Inicial";
	protected static final int opcoesPorLinha = 4;

	public Tela(String nome, String[] opcoes) {
		this.nome = nome;
		this.opcoes = opcoes;
	}


	// private void opcao1() {
	// 	throw new RuntimeException();
	// };
	// private void opcao2() {};
	// private void opcao3() {};
	// private void opcao4() {};
	// private void opcao5() {};
	// private void opcao6() {};
	// private void opcao7() {};
	// private void opcao8() {};

	protected abstract void opcao1();
	protected abstract void opcao2();
	protected abstract void opcao3();
	protected abstract void opcao4();
	protected abstract void opcao5();
	protected abstract void opcao6();
	protected abstract void opcao7();
	protected abstract void opcao8();
	protected abstract void mostraInfo();

	protected void iniciar() {
		while (true) {
			try {
				
				this.mostrar();
				System.out.print("Escolha uma opção... ");
				switch (Console.lerInt(1, this.opcoes.length)) {
					case 1:
						this.opcao1();
						break;
					case 2:
						this.opcao2();
						break;
					case 3:
						this.opcao3();
						break;
					case 4:
						this.opcao4();
						break;
					case 5:
						this.opcao5();
						break;
					case 6:
						this.opcao6();
						break;
					case 7:
						this.opcao7();
						break;
					case 8:
						this.opcao8();
						break;
				}
			} catch (SairDaTelaException s) {
				break;
			}
		}
	}

	protected void mostrar() {
		this.mostraCabecalho();
		this.mostraOpcoes();
		this.mostraInfo();
		System.out.println();
	}

	protected void mostraOpcoes() {
		for (int i = 0; i < opcoes.length; i += opcoesPorLinha) {
			String linha = "";
			for (int j = 0; j < opcoesPorLinha; j++) {
				try {
					linha += String.format("%d: %s    ", i + j + 1, opcoes[j + i]);
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}
			Console.printaCentro(linha);
			System.out.println();
		}
	}

	protected void mostraCabecalho() {
		Console.limparConsole();
		Console.printaCentro("", '-');
		Console.printaCentro("Banco do Jay", '-');
		Console.printaCentro("", '-');
		Console.printaCentro("Aqui seu dinheiro é meu", '-');
		Console.printaCentro("(Não, pera.. é seu, mas eu controlo!)", '-');
		Console.printaCentro("(Não... eu cuido!)", '-');
		Console.printaCentro("", '-');
		System.out.println();
		Console.printaCentro(nome);
		System.out.println();
	}

}
