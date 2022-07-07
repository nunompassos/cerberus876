package br.com.letscode;

import java.util.ArrayList;

import br.com.letscode.Classes.Conta;
import br.com.letscode.Classes.ContaCorrente;
import br.com.letscode.Classes.ContaPoupanca;
import br.com.letscode.Classes.ContaInvestimento;
import br.com.letscode.Classes.User;

public class App {
    public static int countUsers = 1;
    public static int countContas = 1;

    public static ArrayList<User> user = new ArrayList<>();
    public static ArrayList<Conta> contasCorrentes = new ArrayList<>();
    ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();
    ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<>();

    private static void criarConta(int numero, int personalidade) {
        App.countContas++;
        // App.contas.add(new Conta());
        System.out.printf("Anota aí! O número da sua conta é", App.countContas);
    }

    public static void main(String[] args) {
        User usuario = new User(1, "Fulano", "JURIDICA");
        ContaInvestimento containvestimento = new ContaInvestimento(usuario, "INVESTIMENTO");
        ContaCorrente contacorrente = new ContaCorrente(usuario, "CORRENTE");
        ContaPoupanca contapoupanca = new ContaPoupanca(usuario, "POUPANCA");
        containvestimento.depositar(containvestimento, "100");
        contacorrente.depositar(contacorrente, "100");
        contapoupanca.depositar(contapoupanca, "100");



        System.out.println(containvestimento.getSaldo());
        contacorrente.transferir(contacorrente, contapoupanca, "50");
        System.out.println(containvestimento.getSaldo());
        contacorrente.investir(contacorrente, containvestimento, "10");
        System.out.println(containvestimento.getSaldo());
        System.out.println(containvestimento.getRendimento());

        


    }
}
