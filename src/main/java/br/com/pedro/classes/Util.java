package br.com.pedro.classes;

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

    public static void logo() {
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
}
