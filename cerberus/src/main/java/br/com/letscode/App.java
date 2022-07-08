package br.com.letscode;

import java.math.RoundingMode;
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
        System.out.println("\nUser criado com sucesso. Novo user:\n" + users.get(users.size() - 1).toString());
    }

    static void criarConta(User user, String tipoConta) {
        TipoDeConta tc = TipoDeConta.valueOf(tipoConta);
        switch (tc) {
            case CORRENTE:
                contas.add(new ContaCorrente(user, tc));
                System.out.println(
                        "\n\nConta criada com sucesso. Nova conta: \n" + contas.get(contas.size() - 1).toString()
                                + "\nEfetue o login novamente para utilizá-la.");
                break;
            case POUPANCA:
                if (user.getTipoPessoa() == Personalidade.JURIDICA) {
                    System.out.printf("Impossível conta poupança para pessoa Jurídica.\n");
                    break;
                } else {
                    contas.add(new ContaPoupanca(user, tc));
                    System.out.println(
                            "\n\nConta criada com sucesso. Nova conta: \n\n" + contas.get(contas.size() - 1).toString()
                                    + "\nEfetue o login novamente para utilizá-la.");
                }
                break;
            case INVESTIMENTO:
                contas.add(new ContaInvestimento(user, tc));
                System.out.println(
                        "\n\nConta criada com sucesso. Nova conta: \n\n" + contas.get(contas.size() - 1).toString()
                                + "\nEfetue o login novamente para utilizá-la.");
                break;
        }
    }

    // Faz incidir o rendimento mensal em todas as contas.
    static void virarMes() {
        for (Conta conta : contas) {
            conta.setSaldo(conta.getSaldo().multiply(conta.getRendimento()).setScale(2, RoundingMode.HALF_UP));
        }
    }

    public static final void printUser() {
        System.out.println("\n\n\n\n\n\nUSERS EXISTENTES");
        System.out.println("-------------------------------------");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println("-------------------------------------");
    }

    // Imprime todas as conta, com informações relevantes (usando o override do
    // toString()).
    public static final void printContas() {
        System.out.println("\nCONTAS EXISTENTES");
        System.out.println("-------------------------------------");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(contas.get(i) + "  -  Rendimento: " + contas.get(i).rendimentoFormatter());
        }
        System.out.println("-------------------------------------");
    }

    static void interativo() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            User loggedUser = null;
            Conta loggedAcc = null;
            // BigDecimal valorOperação;
            int idTemp = -1;
            String valorTemp = "0";
            System.out.println("Digite um ID para efetuar o login: ");
            loggedUser = users.get(Integer.parseInt(scanner.next()));
            loggedUser.minhasContas();
            System.out.println("\nDigite o número da conta em que deseja realizar operações.");
            loggedAcc = contas.get(Integer.parseInt(scanner.next()));
            boolean logado = true;
            while (logado) {
                System.out.println("\nPrecione Enter para continuar.");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
                System.out.println("\nLogado: " + loggedAcc.toString() + "\n");
                System.out.println("1 - Abrir outra conta.\n2 - Sacar. \n3 - Depositar.\n4 - Transferir.");
                System.out.println(
                        "5 - Investir.\n6 - Consultar saldo.\n\n7 - Passar um mês (para ver os rendimentos).");
                System.out.println(
                        "8 - Ver detalhes de todas as contas do banco.\n\n9 - Trocar de usuário/conta \n0 - Sair.\n");

                int optInt = Integer.parseInt(scanner.next());
                OpcoesMenu[] opcoes = OpcoesMenu.values();

                switch (opcoes[optInt]) {
                    case SAIR: // 0
                        running = false;
                        break;
                    case ABRIR: // 1
                        System.out
                                .println("Digite o tipo de conta que deseja criar: CORRENTE, POUPANCA ou INVESTIMENTO");
                        criarConta(loggedUser, scanner.next());
                        break;
                    case SACAR: // 2
                        System.out.println("Quanto deseja sacar?   valor: ");
                        loggedAcc.sacar(scanner.next());
                        System.out.println("\nOperação realizada com sucesso.\nNovo saldo: " + loggedAcc.getSaldo()
                                + "\n--------------");
                        break; // 3
                    case DEPOSITAR:
                        System.out.println("Valor: ");
                        valorTemp = scanner.next();
                        Conta.depositar(loggedAcc, valorTemp);
                        System.out.println("\nOperação realizada com sucesso.\nNovo saldo: " + loggedAcc.getSaldo()
                        + "\n--------------");
                        break;
                    case TRANSFERIR: // 4
                        System.out.println("Qual o número da conta para qual deseja transferir?");
                        idTemp = Integer.parseInt(scanner.next());
                        if (idTemp >= contas.size()) {
                            System.out.println("Não existe conta com este número informado.");
                        } 
                        else if (idTemp == loggedAcc.getNumeroDaConta()) {
                            System.out.println("Não é possível transferir para esta própria conta.");
                        } 
                        else {
                            System.out.println("Valor: ");
                            valorTemp = scanner.next();
                            loggedAcc.transferir(contas.get(idTemp), valorTemp);
                        }
                        break;
                    case INVESTIR: // 5
                        System.out.println("Quanto deseja investir? Valor: ");
                        loggedAcc.investir(scanner.next());
                        break;
                    case SALDO: // 6
                        loggedAcc.consultarSaldo();
                        break;
                    case PASSAR_UM_MES: // 7
                        virarMes();
                        System.out.println(
                                "\n||||||||||||||||||||| >Após rendimento, os saldos subiram em:\n||||||||||||||||||||| > 0,5% Poupança \n||||||||||||||||||||| > 1% Conta Investimento (PF) \n||||||||||||||||||||| > 1% + 2% Conta Investimento (PJ)");
                        printContas();
                        break;
                    case TODAS_AS_CONTAS: // 8
                        printContas();
                        break;
                    case TROCAR_USUARIO: // 9
                        logado = false;
                        break;
                    default:
                }
            }
            interativo();
        }
        scanner.close();
    }

    public static void main(String[] args) throws InterruptedException {
        // Criando usuários PF e PJ.
        criarUser("userPF de Sousa", "FISICA"); // user Id 0, Pessoa Física
        criarUser("userPJ Empreendimentos", "JURIDICA"); // user id 1, Pessoa Jurídica

        // Criando contas do userPF.
        criarConta(users.get(0), "CORRENTE");
        criarConta(users.get(0), "POUPANCA");
        criarConta(users.get(0), "INVESTIMENTO");
        // Criando contas do userPJ.
        criarConta(users.get(1), "CORRENTE");
        criarConta(users.get(1), "INVESTIMENTO");

        // Depositando R$ 1.000,00 em cada, Para facilitar testes de operações.
        Conta.depositar(contas.get(0), "1000");
        Conta.depositar(contas.get(1), "1000");
        Conta.depositar(contas.get(2), "1000");
        Conta.depositar(contas.get(3), "1000");
        Conta.depositar(contas.get(4), "1000");
        printUser();
        interativo();
    }
}
