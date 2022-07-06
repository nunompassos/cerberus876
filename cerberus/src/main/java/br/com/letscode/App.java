package br.com.letscode;

import java.util.ArrayList;

import br.com.letscode.Classes.Conta;
import br.com.letscode.Classes.ContaPoupanca;
import br.com.letscode.Classes.ContaInvestimento;
import br.com.letscode.Classes.TipoDeConta;
import br.com.letscode.Classes.User;

public class App {
    public static int countUsers = 0;
    public static int countContas = 0;

    public static ArrayList<User> user = new ArrayList<>();
    public static ArrayList<Conta> contasCorrentes = new ArrayList<>();
    ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();
    ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<>();

    // private static void criarConta(TipoDeConta tipoDeConta) {
    //     switch (tipoDeConta) {
    //         case "CORRENTE":
    //             contasCorrentes.add(new ContaCorrente(tipoDeConta));
    //             countContas++;
    //             break;
    //         case "INVESTIMENTO":
    //             contasInvestimento.add(new ContaInvestimento(tipoDeConta));
    //             countContas++;
    //             break;
    //         case "POUPANCA":
    //             contasPoupancas.acc(new ContaPoupanca(tipoDeConta));
    //             countContas++;
    //             break;
    //         default:
    //             System.out.println("O comando que digitou é invalido.");
    //     }
    //     System.out.printf("%i Anota aí! O número da sua conta é", countContas);

    // }

    public static void main(String[] args) {
        // criarConta();
        // System.out.println(countContas);
        // ContaCorrente contaCorrente1 = new ContaCorrente(TipoDeConta.valueOf("CORRENTE"));

    }
}
