package br.com.letscode.telas;

import java.util.Scanner;

public class Tela {

	protected Tela(String nome, String[] opcoes, Scanner sc) {
		this.sc = sc;
		this.opcoes = opcoes;
		this.nome = nome;
		this.mostrar();
	}

	protected Scanner sc;
	private String[] opcoes;
	private String nome;
	private static final int opcoesPorLinha = 4;

	public void mostrar() {
		this.mostraCabecalho();
		this.mostraOpcoes();
	}

	public void mostraOpcoes() {
		for (int i = 0; i < opcoes.length; i += opcoesPorLinha) {
			String linha = "";
			for (int j = 0; j < opcoesPorLinha; j++) {
				try {
					linha += String.format("%d: %s    ", i + j + 1, opcoes[j + i]);
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}
			printaCentro(linha);
			System.out.println();
		}
	}

	public void mostraCabecalho() {
		limparConsole();
		printaCentro("", '-');
		printaCentro("Banco do Jay", '-');
		printaCentro("", '-');
		printaCentro("Aqui seu dinheiro é meu", '-');
		printaCentro("(Não, pera.. é seu, mas eu controlo!)", '-');
		printaCentro("(Não... eu cuido!)", '-');
		printaCentro("", '-');
		System.out.println();
		printaCentro(nome);
		System.out.println();
		System.out.println();
	}

	private static void printaCentro(String s) {
		printaCentro(s, ' ');
	}

	private static void printaCentro(String s, char c) {
		System.out.println(centraliza(s, c));
	}

	private static String centraliza(String s) {
		return centraliza(s, ' ');
	}

	private static String centraliza(String s, char c) {
		int comeco = (80 - s.length()) / 2;
		if (comeco < 0) {
			s = s.substring(0, 80);
			comeco = 0;
		}
		// Protegendo os espaços
		s = s.replace(' ', '~');
		// Botando c na frente e atrás
		String saida = new String(new char[comeco]);
		saida = saida.replace((char) 0, c);
		saida += s;
		saida = String.format("%-80s", saida).replace(' ', c);
		saida = saida.replace('~', ' ');
		return saida;

	}

	private static void limparConsole() {
		try {
			String operatingSystem = System.getProperty("os.name"); // Check the current operating system
			if (operatingSystem.contains("Windows")) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			} else {
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] opcoes = { "Entrar", "Cadastrar", "Sair", "Coisa", "Trem" };
		Tela t = new Tela("Tela inicial", opcoes, sc);
		sc.nextLine();

	}
}
