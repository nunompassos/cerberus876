package br.com.letscode;

import java.util.ArrayList;

import br.com.letscode.Classes.Conta;
import br.com.letscode.Classes.ContaCorrente;
import br.com.letscode.Classes.ContaPoupanca;
import br.com.letscode.Classes.Personalidade;
import br.com.letscode.Classes.TipoDeConta;
import br.com.letscode.Classes.ContaInvestimento;
import br.com.letscode.Classes.User;

public class App {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Conta> contas = new ArrayList<>();

    public static ArrayList<Conta> contasUser = new ArrayList<>();


    static void criarUser(String nome, String tipoPessoa) {
        users.add(new User(nome, tipoPessoa));
        System.out.println("O seu numero para login é: " + (users.size() - 1));
    }

    static void criarConta(User user, String tipoConta) {
        TipoDeConta tc = TipoDeConta.valueOf(tipoConta);
        switch (tc) {
            case CORRENTE:
                contas.add(new ContaCorrente(user, tc));
                break;
            case POUPANCA:
                if (user.getTipoPessoa() == Personalidade.JURIDICA) {
                    System.out.println("Impossível conta poupança para pessoa Jurídica.");
                    break;
                } else {
                    contas.add(new ContaPoupanca(user, tc));
                }
                break;
            case INVESTIMENTO:
                contas.add(new ContaInvestimento(user, tc));
                break;
        }
        // contas.add(new Conta(user, tipoConta));
        System.out.println("Anota aí! O número desta sua nova conta é: " + (contas.size() - 1));
    }

    

    static void virarMes() {
        for (Conta conta : contas) {
            conta.setSaldo(conta.getSaldo().multiply(conta.getRendimento()));
        }
    }

    public static void main(String[] args) {
        criarUser("userPF", "FISICA"); // user 0
        criarUser("userPJ", "JURIDICA"); // user 1

        // PF
        criarConta(users.get(0), "CORRENTE"); // conta 0
        criarConta(users.get(0), "POUPANCA"); // conta 1
        criarConta(users.get(0), "INVESTIMENTO"); // conta 2
        // PJ
        criarConta(users.get(1), "CORRENTE"); // conta 3
        criarConta(users.get(1), "INVESTIMENTO"); // conta 4

        contas.add(new ContaInvestimento(users.get(1), TipoDeConta.INVESTIMENTO)); // CONTA 5

        contas.get(0).depositar(contas.get(0), "100");
        contas.get(1).depositar(contas.get(1), "100");
        contas.get(3).depositar(contas.get(3), "100");
        contas.get(4).depositar(contas.get(4), "100");

        // System.out.println(contas.get(0).getTipoConta());
        // System.out.println(users.get(1).getId());

        // contas.get(1).transferir(contas.get(0), "10");
        System.out.println(contas.get(0).getSaldo()); // corrente pf
        System.out.println(contas.get(1).getSaldo()); // poupanca pf
        System.out.println(contas.get(2).getSaldo());
        // contas.get(4).transferir(contas.get(3), "10");
        System.out.println(contas.get(4).getSaldo()); // investimento pj
        System.out.println(contas.get(3).getSaldo()); // corrente pj

        virarMes();
        System.out.println("");
        System.out.println(contas.get(0).getSaldo());
        System.out.println(contas.get(1).getSaldo());
        System.out.println(contas.get(2).getSaldo());

        System.out.println(contas.get(4).getSaldo());
        System.out.println(contas.get(3).getSaldo());
        // contas.get(4).transferir(contas.get(3), "90");
        // System.out.println(contas.get(4).getSaldo());
        // System.out.println(contas.get(3).getSaldo());
        System.out.println(contas.get(4).getTipoPessoa());
        System.out.println(contas.get(4).getTipoConta());

        System.out.println(contas.get(5).getRendimento());
        System.out.println(contas.get(5).getClass().getName());
        // contas.get(4).imprimeRendimento();

    }
}
