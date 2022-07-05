package br.com.pedro.classes;

import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws IOException {

        Carga carga = new Carga();

        Scanner sc = new Scanner(System.in);

        logo();

        switch (menuInicial(sc)) {
            case 1:
                menuConsultas(sc);
                break;
            case 2:
                System.out.println("Case 2 escolhido");
                break;
            case 3:
                System.out.println("Case 3 escolhido");
                break;
            default:
                System.out.println("Erro!");
        }

        System.out.println();
        sc.close();
    }

    private static int menuInicial(Scanner sc) {
        System.out.println("01. Consultas");
        System.out.println("02. Transações");
        System.out.println("03. Sair");
        System.out.println();

        int escolhido;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 3 || escolhido < 1);

        return escolhido;
    }

    private static void menuConsultas(Scanner sc) {
        logo();
        System.out.println("01. Consulta Conta Corrente Pessoa Física");
        System.out.println("02. Consulta Conta Corrente Pessoa Jurídica");
        System.out.println("03. Sair");
        System.out.println();

        int escolhido;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 3 || escolhido < 1);

        switch (escolhido) {
            case 1:
                System.out.println(consultaContaCorrentePessoaFisica(sc));
                ;
                break;
            case 2:
                System.out.println("Case 2 escolhido");
                break;
            case 3:
                System.out.println("Case 3 escolhido");
                break;
            default:
                System.out.println("Erro!");
        }
    }

    private static ContaCorrentePessoaFisica consultaContaCorrentePessoaFisica(Scanner sc) {
        logo();
        System.out.println("Digite o número da agência:");

        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            menuConsultas(sc);
        }

        System.out.println("Digite o número da conta:");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (!Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta não localizada");
            menuConsultas(sc);
        }

        return (ContaCorrentePessoaFisica) Agencia.getAgencia(numeroAgencia).getConta(numeroConta);
    }

    private static void logo() {
        ClearConsole();
        System.out.println(" /$$      /$$           /$$$$$$$                      /$$      ");
        System.out.println("| $$$    /$$$          | $$__  $$                    | $$      ");
        System.out.println("| $$$$  /$$$$ /$$   /$$| $$  \\ $$  /$$$$$$  /$$$$$$$ | $$   /$$");
        System.out.println("| $$ $$/$$ $$| $$  | $$| $$$$$$$  |____  $$| $$__  $$| $$  /$$/");
        System.out.println("| $$  $$$| $$| $$  | $$| $$__  $$  /$$$$$$$| $$  \\ $$| $$$$$$/ ");
        System.out.println("| $$\\  $ | $$| $$  | $$| $$  \\ $$ /$$__  $$| $$  | $$| $$_  $$ ");
        System.out.println("| $$ \\/  | $$|  $$$$$$$| $$$$$$$/|  $$$$$$$| $$  | $$| $$ \\  $$");
        System.out.println("|__/     |__/ \\____  $$|_______/  \\_______/|__/  |__/|__/  \\__/");
        System.out.println("              /$$  | $$                                        ");
        System.out.println("             |  $$$$$$/                                        ");
        System.out.println("              \\______/                                         ");
        System.out.println();
    }

    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}