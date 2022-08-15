package br.com.letscode.nivelamento;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EnvioEmail {
    
    public static void main(String[] args) {
        
        String message = "É importante questionar o quanto o julgamento imparcial das eventualidades pode nos levar a considerar a reestruturação das condições financeiras e administrativas exigidas.";
        System.out.println(message);

        Email email = new Email(message);
        Scanner scan = new Scanner(System.in);

        System.out.println("\nPrimeiramente...");
        System.out.println("Você deseja:\n1 - DEIXAR TUDO MAIÚSCULO?\n2 - deixar tudo minúsculo:\n3 - deixarTudoCamelCase?\n0 - Tá bom do jeito que está.");
        int formataCase = scan.nextInt();

        System.out.println("\nAgora...");
        System.out.println("Você deseja:\n1 - Remover a acentuacao?\n0 - Tá bom do jeito que está.");
        int removerAcentuacao = scan.nextInt();

        scan.close();
        
        if (formataCase == 1) {
            email.formatarMaiusculo();
        } else if (formataCase == 2) {
            email.formatarMinusculo();
        } else if (formataCase == 3) {
            email.formatarCamelCase();
        }

        if (removerAcentuacao == 1) {
            email.formatarRemoverAcentuacao();
        }

        System.out.println(email.getMessage());
        email.enviar();
    }
}


class Email {

    private String message;

    public Email(String message) {
        this.message = message;
    }

    public void enviar() {
        System.out.println("E-mail enviado com sucesso.");
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public void formatarMaiusculo() {
        this.setMessage(this.message.toUpperCase());
    }

    public void formatarMinusculo() {
        this.setMessage(this.message.toLowerCase());
    }

    public void formatarCamelCase() {
        String[] words = this.getMessage().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.isEmpty() ? word : word.toLowerCase();
            } else {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();      
            }
            builder.append(word);
        }
        this.setMessage(builder.toString());
    }

    public void formatarRemoverAcentuacao() {
        String normalizer = Normalizer.normalize(this.message, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        this.setMessage(pattern.matcher(normalizer).replaceAll(""));
    }
}
