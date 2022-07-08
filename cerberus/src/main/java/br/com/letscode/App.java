package br.com.letscode;

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
    // Todas as contas são armazenadas neste ArrayList de tipo Conta (classe
    // abstrata),
    // embora as classes dos objetos sejam sempre das classes filhas: ContaCorrente,
    // ContaPoupanca e ContaInvestimento.
    public static ArrayList<Conta> contas = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

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
            User loggedUser = null;
            Conta loggedAcc = null;
            // BigDecimal valorOperação;
            int idtemp = -1;
            String valorTemp = "0";
            System.out.println("Digite seu ID.\n0 - login em usuário PF.\n1 - login em usuário PJ.");
            loggedUser = users.get(Integer.parseInt(scanner.next()));
            loggedUser.minhasContas();
            System.out.println("\nDigite o número da conta em que deseja realizar operações.");
            loggedAcc = contas.get(Integer.parseInt(scanner.next()));
            System.out.println("\nLogado: " + loggedAcc.toString() + "\n");
            System.out.println("1 - Abrir outra conta.\n2 - Sacar. \n3 - Depositar.\n4 - Transferir.");
            System.out.println(
                    "5 - Investir.\n6 - Consultar saldos (poupança e corrente).\n7 - Ver todas as contas do banco.");
            System.out.println("8 - Passar um mês (para ver os rendimentos).\n9 - Voltar para o início");

            int optInt = Integer.parseInt(scanner.next());
            OpcoesMenu[] opcoes = OpcoesMenu.values();

            switch (opcoes[optInt]) {
                case TROCARUSUARIO:
                    System.out.println(
                            "Digite o ID do usuário em que deseja efetuar login. Dica: o de ID 0 é PF e de ID 1 é PJ");
                    loggedUser = users.get(Integer.parseInt(scanner.next()));
                    break;
                case ABRIR:
                    System.out.println("Digite o tipo de conta que deseja criar: CORRENTE, POUPANCA ou INVESTIMENTO");
                    criarConta(loggedUser, scanner.next());
                    break;
                case SACAR:
                    System.out.println("Quanto deseja sacar?   valor: ");
                    loggedAcc.sacar(scanner.next());
                    break;
                case DEPOSITAR:
                    System.out.println("Valor: ");
                    valorTemp = scanner.next();
                    Conta.depositar(loggedAcc, valorTemp);
                    break;
                case TRANSFERIR:
                    System.out.println("Qual o número da conta para qual deseja transferir?");
                    idtemp = Integer.parseInt(scanner.next());
                    System.out.println("Valor: ");
                    valorTemp = scanner.next();
                    loggedAcc.transferir(contas.get(idtemp), valorTemp);
                    break;
                case INVESTIR:
                    System.out.println("Quanto deseja investir?   valor: ");
                    loggedAcc.investir(scanner.next());
                    break;
                case SALDO:
                    if (loggedAcc.getTipoConta() != TipoDeConta.INVESTIMENTO) {
                        loggedAcc.consultarSaldo();
                        break;
                    } else {
                        System.out.println("\nEssa função não está disponível para CONTA " + loggedAcc.getTipoConta());
                        break;
                    }
                case TODASASCONTAS:
                    printContas();
                    break;
                case PASSARUMMES:
                    virarMes();
                    System.out.println(
                            "\nApós rendimento, os saldos subiram em:\n> 0,5% Poupança \n> 1% Conta Investimento (PF) \n> 1% + 2% Conta Investimento (PJ)");
                    printContas();
                case INICIO:
                    interativo();
                default:
                    interativo();

            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Criando usuários PF e PJ.
        criarUser("userPF", "FISICA"); // user Id 0, Pessoa Física
        criarUser("userPJ", "JURIDICA"); // user id 1, Pessoa Jurídica

        // Criando contas do userPF.
        criarConta(users.get(0), "CORRENTE");
        criarConta(users.get(0), "POUPANCA");
        criarConta(users.get(0), "INVESTIMENTO");
        // Criando contas do userPJ.
        criarConta(users.get(1), "CORRENTE");
        criarConta(users.get(1), "INVESTIMENTO");

        // Depositando R$ 1.000,00 em cada.
        Conta.depositar(contas.get(0), "1000");
        Conta.depositar(contas.get(1), "1000");
        Conta.depositar(contas.get(2), "1000");
        Conta.depositar(contas.get(3), "1000");
        Conta.depositar(contas.get(4), "1000");

        printContas();
        interativo();
    }
}
