package br.com.pedro.classes;

import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws IOException {

        Carga carga = new Carga();

        Scanner sc = new Scanner(System.in);

        menuInicial(sc);

        System.out.println();
        sc.close();
    }

    private static void menuInicial(Scanner sc) {
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
                System.out.println("Case 3 escolhido");
                return;
            case 4:
                System.out.println("Case 4 escolhido");
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void menuAberturaDeConta(Scanner sc) {
        Util.logo();
        System.out.println("01.   Abrir Conta Corrente Pessoa Física");
        System.out.println("02.   Abrir Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Retornar ao menu anterior");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 3 || escolhido < 1);

        switch (escolhido) {
            case 1:
                return;
            case 2:
                return;
            case 3:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }

    }

    private static void menuConsultas(Scanner sc) {
        Util.logo();
        System.out.println("01.   Consulta Conta Corrente Pessoa Física");
        System.out.println("02.   Consulta Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Retornar ao menu anterior");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 3 || escolhido < 1);

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
}