package br.com.letscode;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.letscode.Models.Pessoa;
import br.com.letscode.Models.enums.EstadoCivil;
import br.com.letscode.Models.enums.Sexo;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        while (pessoa.getAltura() == null) {
            try {
                System.out.print("Altura (em m²): ");
                pessoa.setAltura(new BigDecimal(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Por favor, digite um numero válido");
            }
        }
        EstadoCivil.whileEstadoCivilNotNull(scanner, pessoa);
        Sexo.whileSexoNotNull(scanner, pessoa);

        while (pessoa.getIdade() == 0) {
            System.out.println("Idade: ");
            String idadeEmString = scanner.nextLine();
            int idade = 0;
            try {
                idade = Integer.parseInt(idadeEmString);
            } catch (Exception e) {
                System.out.println("Por favor, selecione um numero válido");
            }
            if (idade <= 0) {
                idade = 0;
            }
            pessoa.setIdade(idade);
        }
        System.out.println("Nome: ");
        pessoa.setNome(scanner.nextLine());
        while (pessoa.getPeso() == null) {
            try {
                System.out.println("Peso: ");
                pessoa.setPeso(new BigDecimal(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Por favor, digite um numero válido");
            }
        }
        while (pessoa.getEndereco() == "" || pessoa.getEndereco() == null) {
            System.out.println("Endereço: ");
            pessoa.setEndereco(scanner.nextLine());
        }
        System.out.println(pessoa.toString());
        scanner.close();
    }
}
