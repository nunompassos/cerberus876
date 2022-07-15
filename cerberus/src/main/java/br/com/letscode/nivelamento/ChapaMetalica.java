package br.com.letscode.nivelamento;

public class ChapaMetalica {

    private double[][] matriz;
    private double[][] matrizAtual;
    private int linhas;
    private int colunas;
    private int etapa = 0;

    public ChapaMetalica(int linhas, int colunas) {
        matriz = new double[linhas][colunas];
    }
    

    public static void main(String[] args) {
        ChapaMetalica matriz = new ChapaMetalica(5, 6);
        matriz.imprimirMatriz();
        matriz.popularMatrizComValoresIniciais();
        matriz.imprimirMatriz();
        matriz.rodarEtapa();
        matriz.imprimirMatriz();
        
    }

    public void gerarMatrizNula() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public void popularMatrizComValoresIniciais() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (j == 0) {
                    this.matriz[i][j] = 100.0;
                }
                if (j == this.matriz[i].length - 1) {
                    this.matriz[i][j] = -3.0;
                }
                if (i == 0) {
                    this.matriz[i][j] = 20.0;
                }
                if (i == this.matriz.length - 1) {
                    this.matriz[i][j] = 20.0;
                }
            }
        }
    }

    public void imprimirMatriz() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                System.out.printf("  %.2f  ", this.matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void rodarEtapa() {
        for (int i = 1; i < this.matriz.length -1; i++) {
            for (int j = 1; j < this.matriz[i].length -1; j++) {
                this.matriz[i][j] = calcularMediaDeTemperaturasDaVizinhanca(i, j);
            }
        }
    }

    public double calcularMediaDeTemperaturasDaVizinhanca(int i, int j) {
        return (this.matriz[i-1][j] + this.matriz[i+1][j] + this.matriz[i][j-1] + this.matriz[i][j+1]) / 4;
    }
}
