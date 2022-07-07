package br.com.letscode;

import java.util.ArrayList;

import br.com.letscode.Classes.Conta;
import br.com.letscode.Classes.ContaCorrente;
import br.com.letscode.Classes.ContaPoupanca;
import br.com.letscode.Classes.ContaInvestimento;
import br.com.letscode.Classes.User;

public class App {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Conta> contas = new ArrayList<>();

    static void criarUser(String nome, String tipoPessoa) {
        users.add(new User(nome, tipoPessoa));
        System.out.println("O seu numero para login é: " + (users.size() - 1));
    }

    static void criarConta(User user, String tipoConta) {
        contas.add(new Conta(user, tipoConta));
        System.out.println("Anota aí! O número da sua conta " + tipoConta + " é: " + (contas.size() -1));
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

        
        contas.get(0).depositar(contas.get(0), "100");
        contas.get(1).depositar(contas.get(1), "100");
        
        // System.out.println(contas.get(0).getTipoConta());
        System.out.println(users.get(1).getId());


        


    }
}
