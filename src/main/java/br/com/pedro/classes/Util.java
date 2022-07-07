package br.com.pedro.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public abstract class Util {
    
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

    public static void logo(String menuCabecalho) {
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
        System.out.println("\n");
        menuCabecalho(menuCabecalho);
        System.out.println();
    }

    public static void aguardarEnter(Scanner sc) {
        System.out.print("Pressione ENTER para retornar ao menu anterior   ");
        sc.nextLine();
    }

    private static void menuCabecalho(String menuCabecalho) {

        final int TAMANHO = 65;
        menuCabecalho = String.format(" %s ", menuCabecalho);
        int tamanhoAposMensagem = TAMANHO - menuCabecalho.length();
        int tracejadoEsquerdo;
        int tracejadoDireito;
        if (tamanhoAposMensagem % 2 == 0) {
            tracejadoEsquerdo = tamanhoAposMensagem / 2;
            tracejadoDireito = tamanhoAposMensagem / 2;
        } else {
            tracejadoEsquerdo = tamanhoAposMensagem / 2;
            tracejadoDireito = (tamanhoAposMensagem / 2) + 1;
        }

        StringBuilder menuCabecalhoCompleto = new StringBuilder();
        for (int i = 0; i < tracejadoEsquerdo; i++) {
            menuCabecalhoCompleto.append("-");
        }

        menuCabecalhoCompleto.append(menuCabecalho);

        for (int i = 0; i < tracejadoDireito; i++) {
            menuCabecalhoCompleto.append("-");
        }

        System.out.println(menuCabecalhoCompleto);
    }

    public static String lerStringFormatada(Scanner sc, String pedido, String erro, int lowerBound) {
        pedidoFormatado(pedido);
        String nome;
        do {
            nome = sc.nextLine();
            if (nome.length() < lowerBound) {
                System.out.println(erro);
                System.out.println();
                pedidoFormatado(pedido);
            }
        } while (nome.length() < lowerBound);
        return nome;
    }
    
    public static int lerInt(Scanner sc, String pedido, String erro, int lowerBound, int upperBound) {
        System.out.print(pedido);
        int numero;
        do {
            numero = Integer.MIN_VALUE;
            try {
                numero = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            
            if (numero < lowerBound || numero > upperBound) {
                System.out.println(erro);
                System.out.println();
                System.out.print(pedido);
            }
        } while (numero < lowerBound || numero > upperBound);
        return numero;
    }

    public static int lerIntFormatado(Scanner sc, String pedido, String erro, int lowerBound) {
        pedidoFormatado(pedido);
        int numero;
        do {
            numero = Integer.MIN_VALUE;
            try {
                numero = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            
            if (numero < lowerBound) {
                System.out.println(erro);
                System.out.println();
                pedidoFormatado(pedido);
            }
        } while (numero < lowerBound);
        return numero;
    }

    public static int lerIntFormatado(Scanner sc, String pedido, String erro, int lowerBound, int upperBound) {
        pedidoFormatado(pedido);
        int numero;
        do {
            numero = Integer.MIN_VALUE;
            try {
                numero = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            
            if (numero < lowerBound || numero > upperBound) {
                System.out.println(erro);
                System.out.println();
                pedidoFormatado(pedido);
            }
        } while (numero < lowerBound || numero > upperBound);
        return numero;
    }

    public static BigDecimal lerBigDecimalFormatado(Scanner sc, String pedido, String erro, BigDecimal lowerBound) {
        pedidoFormatado(pedido);
        double numero;
        do {
            numero = Double.MIN_VALUE;
            try {
                numero = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            
            if (BigDecimal.valueOf(numero).compareTo(lowerBound) < 0) {
                System.out.println(erro);
                System.out.println();
                pedidoFormatado(pedido);
            }
        } while (BigDecimal.valueOf(numero).compareTo(lowerBound) < 0);
        return BigDecimal.valueOf(numero).setScale(2, RoundingMode.HALF_UP);
    }

    private static void pedidoFormatado(String pedido) {
        final int TAMANHO = 30;
        int adicionarPontos = TAMANHO - pedido.length();
        StringBuilder pedidoFormatado = new StringBuilder();
        pedidoFormatado.append(pedido).append(" ");

        for(int i = 0; i < adicionarPontos; i++) {
            pedidoFormatado.append(".");
        }

        pedidoFormatado.append(":   ");
        System.out.print(pedidoFormatado);
    }
}
