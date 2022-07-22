package br.com.letscode.nivelamento;

import java.util.Scanner;

public class ChapaMetalicaApp {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a quantidade de linhas da chapa: ");
        int linhas = scan.nextInt();
        System.out.print("Digite a quantidade de colunas da chapa: ");
        int colunas = scan.nextInt();
        System.out.print("Digite a quantidade máxima de iterações: ");
        int maximoIteracoes = scan.nextInt();

        System.out.print("Temperatura inicial do lado esquedro da chapa: ");
        double esquerda = scan.nextDouble();
        System.out.print("Temperatura inicial do lado direito da chapa: ");
        double direita = scan.nextDouble();
        System.out.print("Temperatura inicial do lado superior da chapa: ");
        double superior = scan.nextDouble();
        System.out.print("Temperatura inicial do lado inferior da chapa: ");
        double inferior = scan.nextDouble();

        System.out.print("Digite a quantidade de casas decimais: ");
        int casasDecimais = scan.nextInt();
        System.out.print("Digite o erro máximo aceitável (Exemplo: 0,000001): ");
        double erroMaximoAceitavel = scan.nextDouble();

        scan.close();

        ChapaMetalica matriz = new ChapaMetalica(linhas, colunas, casasDecimais, erroMaximoAceitavel);
        matriz.popularMatrizComValoresIniciais(esquerda, direita, superior, inferior);
        matriz.popularMatrizAuxiliar();

        System.out.println("\nCalculando...\n");

        do {
            matriz.rodarEtapa();
            if (matriz.getEtapa() == maximoIteracoes) {
                break;
            }
        } while (!matriz.estaEmEquilibrioTermico());
        
        System.out.printf("Está em equilíbrio térmico? %s\n", matriz.estaEmEquilibrioTermico() ? "SIM" : "NÃO");
        System.out.printf("Iterações até equilíbrio térmico: %d\n", matriz.getEtapa());

        matriz.imprimirMatriz(matriz.getMatriz());

    }
}
