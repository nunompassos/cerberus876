package br.com.letscode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.letscode.Classes.Conta;
import br.com.letscode.Classes.ContaCorrente;
import br.com.letscode.Classes.ContaPoupanca;
import br.com.letscode.Classes.OpcoesMenu;
import br.com.letscode.Classes.Personalidade;
import br.com.letscode.Classes.TipoDeConta;
import br.com.letscode.Classes.ContaInvestimento;
import br.com.letscode.Classes.User;

public class App {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Conta> contas = new ArrayList<>();

    static void criarUser(String nome, String tipoPessoa) {
        users.add(new User(nome, tipoPessoa));
    }

    static void criarConta(User user, String tipoConta) {
        TipoDeConta tc = TipoDeConta.valueOf(tipoConta);
        switch (tc) {
            case CORRENTE:
                contas.add(new ContaCorrente(user, tc));
                break;
            case POUPANCA:
                if (user.getTipoPessoa() == Personalidade.JURIDICA) {
                    System.out.printf("Impossível conta poupança para pessoa Jurídica.\n");
                    break;
                } else {
                    contas.add(new ContaPoupanca(user, tc));
                }
                break;
            case INVESTIMENTO:
                contas.add(new ContaInvestimento(user, tc));
                break;
        }
    }

    // Faz incidir o rendimento mensal em todas as contas.
    static void virarMes() {
        for (Conta conta : contas) {
            conta.setSaldo(conta.getSaldo().multiply(conta.getRendimento()));
        }
    }

    // Imprime todas as conta, com informações relevantes (usando o override do
    // toString()).
    public static final void printContas() {
        System.out.println("\nCONTAS EXISTENTES");
        System.out.println("-------------------------------------");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(contas.get(i));
        }
        System.out.println("-------------------------------------");
    }

    static void interativo() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            User LoggedUser = null;
            Conta LoggedAcc = null;
            BigDecimal valorOperação;
            int idtemp = -1;
            String valorTemp = "0";
            System.out.println("0 - login em usuário PF.");
            System.out.println("1 - login em usuário PJ.");
            LoggedAcc = contas.get(Integer.parseInt(scanner.next()));
            System.out.println("O que deseja fazer?\n ");


            int optInt = Integer.parseInt(scanner.next());
            OpcoesMenu[] opcoes = OpcoesMenu.values();

            switch (opcoes[optInt]) {
                case TROCARUSUARIO:
                    System.out.println(
                            "Digite o ID do usuário em que deseja efetuar login. Dica: o de ID 0 é PF e de ID 1 é PJ");
                    LoggedUser = users.get(Integer.parseInt(scanner.next()));
                    break;
                case ABRIR:
                    System.out.println("Digite o tipo de conta que deseja criar: CORRENTE, POUPANCA ou INVESTIMENTO");
                    criarConta(LoggedUser, scanner.next());
                    break;
                case SACAR:
                    System.out.println("Quanto deseja sacar?   valor: ");
                    LoggedAcc.sacar(scanner.next());
                    break;
                case DEPOSITAR:
                    System.out.println("Qual o número da conta em que deseja depositar?");
                    idtemp = Integer.parseInt(scanner.next());
                    System.out.println("Valor: ");
                    valorTemp = scanner.next();
                    Conta.depositar(contas.get(idtemp), valorTemp);
                    break;
                case TRANSFERIR:
                    System.out.println("Qual o número da conta para qual deseja transferir?");
                    idtemp = Integer.parseInt(scanner.next());
                    System.out.println("Valor: ");
                    valorTemp = scanner.next();
                    LoggedAcc.transferir(contas.get(idtemp), valorTemp);
                    break;
                case INVESTIR:
                    System.out.println("Quanto deseja investir?   valor: ");
                    LoggedAcc.investir(scanner.next());
                    break;
                case SALDO:
                    if (LoggedAcc.getTipoConta() != TipoDeConta.INVESTIMENTO) {
                        System.out.println("Seu saldo é de: " + LoggedAcc.getSaldo());
                        break;
                    }
                    else {
                        System.out.println("Essa função não está disponível para CONTA " + LoggedAcc.getTipoConta());
                    }
                case TODASASCONTAS:
                    printContas();
                    break;

            }
        }

    }

    public static void main(String[] args) {
        // Criando usuários PF e PJ.
        criarUser("userPF", "FISICA"); // user Id 0, Pessoa Física
        criarUser("userPJ", "JURIDICA"); // user id 1, Pessoa Jurídica

        // Criando contas do userPF.
        criarConta(users.get(0), "CORRENTE"); // conta n. 0
        criarConta(users.get(0), "POUPANCA"); // conta n. 1.
        criarConta(users.get(0), "INVESTIMENTO"); // conta n. 2
        // Criando contas do userPJ.
        criarConta(users.get(1), "CORRENTE"); // conta 3, Corrente, de usuário PJ.
        criarConta(users.get(1), "INVESTIMENTO"); // conta 4, Investimento, de usuário PJ.

        // Teste para tentar criar conta Poupança em usuário PJ. Sairá o erro no
        // console.
        System.out.println("\nTeste para tentar criar Poupança mara usuário PJ:");
        criarConta(users.get(1), "POUPANCA");

        // Depositando R$ 1.000,00 em cada.
        Conta.depositar(contas.get(0), "1000");
        Conta.depositar(contas.get(1), "1000");
        Conta.depositar(contas.get(2), "1000");
        Conta.depositar(contas.get(3), "1000");
        Conta.depositar(contas.get(4), "1000");

        // For loop para imprimir todas as contas existentes no ArrayList<Conta>.
        printContas();

        // testar o rendimento de cada uma delas.
        virarMes();
        System.out.println(
                "Após rendimento, os saldos subiram em:\n> 0,5% Poupança \n> 1% Conta Investimento (PF) \n> 1% + 2% Conta Investimento (PJ)");
        printContas();
        interativo();
    }
}
