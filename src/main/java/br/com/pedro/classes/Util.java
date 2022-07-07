package br.com.pedro.classes;

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
        sc.nextLine();
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
}
