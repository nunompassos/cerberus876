package br.com.pedro.classes;

import java.io.IOException;
import java.util.Scanner;

import br.com.pedro.classes.ClientePessoaFisica.EstadoCivil;

public class Aplicacao {

    public static void main(String[] args) throws IOException, ClienteException, ContaException {

        Carga carga = new Carga();

        Scanner sc = new Scanner(System.in);

        menuInicial(sc);

        System.out.println();
        sc.close();
    }

    private static void menuInicial(Scanner sc) throws ClienteException, ContaException {
        Util.logo();
        System.out.println("01.   Abertura de Conta");
        System.out.println("02.   Consultas");
        System.out.println("03.   Transações");
        System.out.println("04.   Sair");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                menuAberturaDeConta(sc);
                return;
            case 2:
                menuConsultas(sc);
                return;
            case 3:
                menuTransacoes(sc);
                return;
            case 4:
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void menuAberturaDeConta(Scanner sc) throws ClienteException, ContaException {
        Util.logo();
        System.out.println("01.   Abrir Conta Corrente Pessoa Física");
        System.out.println("02.   Abrir Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Abrir Conta Poupanca");
        System.out.println("04.   Retornar ao menu anterior");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                aberturaDeContaPessoaFisica(sc);
                menuAberturaDeConta(sc);
                return;
            case 2:
                aberturaDeContaPessoaJuridica(sc);
                menuAberturaDeConta(sc);
                return;
            case 3:
                aberturaDeContaPoupanca(sc);
                menuAberturaDeConta(sc);
                return;
            case 4:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void aberturaDeContaPessoaFisica(Scanner sc) throws ClienteException, ContaException {
        Util.logo();

        System.out.print("Digite o nome do cliente ....:   ");
        String nome;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            nome = sc.next();
        } while (nome.length() < 3);

        System.out.print("Digite o CPF do cliente .....:   ");
        String cpf;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            cpf = sc.next();
        } while (cpf.length() < 11);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta já existe");
            return;
        }

        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(
                nome,
                cpf,
                EstadoCivil.CASADO);

        ContaCorrentePessoaFisica conta = new ContaCorrentePessoaFisica(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaFisica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
        String retornarpf = sc.next();
    }

    private static void aberturaDeContaPessoaJuridica(Scanner sc) throws ClienteException, ContaException {
        Util.logo();

        System.out.print("Digite o nome da empresa ....:   ");
        String nome;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            nome = sc.next();
        } while (nome.length() < 3);

        System.out.print("Digite o CNPJ da empresa ....:   ");
        String cnpj;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            cnpj = sc.next();
        } while (cnpj.length() < 15);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta já existe");
            return;
        }

        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica(
                nome,
                cnpj);

        ContaCorrentePessoaJuridica conta = new ContaCorrentePessoaJuridica(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaJuridica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
        String retornarpj = sc.next();

    }

    private static void aberturaDeContaPoupanca(Scanner sc) throws ClienteException, ContaException {
        Util.logo();

        System.out.print("Digite o nome do cliente ....:   ");
        String nome;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            nome = sc.next();
        } while (nome.length() < 3);

        System.out.print("Digite o CPF do cliente .....:   ");
        String cpf;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            cpf = sc.next();
        } while (cpf.length() < 11);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta já existe");
            return;
        }

        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(
                nome,
                cpf,
                EstadoCivil.CASADO);

        ContaPoupanca conta = new ContaPoupanca(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaFisica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
        String retornarpf = sc.next();
    }

    private static void menuConsultas(Scanner sc) throws ClienteException, ContaException {
        Util.logo();
        System.out.println("01.   Consulta Conta Corrente Pessoa Física");
        System.out.println("02.   Consulta Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Consulta Conta Poupanca");
        System.out.println("04.   Retornar ao menu anterior");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                ContaCorrentePessoaFisica pf = (ContaCorrentePessoaFisica) consultaConta(sc);
                if (pf == null) {
                    menuConsultas(sc);
                    return;
                }
                Util.logo();
                System.out.println(pf);
                System.out.println();
                System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
                String retornarpf = sc.next();
                menuConsultas(sc);
                return;
            case 2:
                ContaCorrentePessoaJuridica pj = (ContaCorrentePessoaJuridica) consultaConta(sc);
                if (pj == null) {
                    menuConsultas(sc);
                    return;
                }
                Util.logo();
                System.out.println(pj);
                System.out.println();
                System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
                String retornarpj = sc.next();
                menuConsultas(sc);
                return;
            case 3:
                ContaPoupanca poup = (ContaPoupanca) consultaConta(sc);
                if (poup == null) {
                    menuConsultas(sc);
                    return;
                }
                Util.logo();
                System.out.println(poup);
                System.out.println();
                System.out.print("Digite qualquer coisa e pressione ENTER para retornar ao menu anterior   ");
                String retornarPoup = sc.next();
                menuConsultas(sc);
                return;
            case 4:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static Conta consultaConta(Scanner sc) {
        Util.logo();
        System.out.print("Digite o número da agência ..:   ");

        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            return null;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (!Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta não localizada");
            return null;
        }

        return Agencia.getAgencia(numeroAgencia).getConta(numeroConta);
    }

    
    private static void menuTransacoes(Scanner sc) throws ClienteException, ContaException {
        Util.logo();
        System.out.println("01.   Depositar");
        System.out.println("02.   Sacar");
        System.out.println("03.   Transferir");
        System.out.println("04.   Investir");
        System.out.println("05.   Poupar");
        System.out.println("06.   Retornar ao menu anterior");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 6 || escolhido < 1);

        switch (escolhido) {
            case 1:
                return;
            case 2:
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }
}