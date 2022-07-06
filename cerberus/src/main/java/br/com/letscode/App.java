package br.com.letscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.letscode.Models.Pessoa;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        int opcao = 0;
        String[] opcoes = { "1 - Criar uma pessoa", "2 - Criar uma conta", "99 - SAIR" };
        System.out.println("O que deseja fazer?");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(opcoes[i]);
        }
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                Pessoa pessoa = Pessoa.createPessoa();
                pessoas.add(pessoa);
                System.out.println(pessoas);
                break;
            case 2:
                
                break;
            case 99:
                System.out.println("SAIR");
                scanner.close();
                break;
            default:

                break;
        }
    }
}
