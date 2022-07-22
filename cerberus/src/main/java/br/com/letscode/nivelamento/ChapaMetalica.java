package br.com.letscode.nivelamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ChapaMetalica {

    private double[][] matriz;
    private double[][] matrizAuxiliar;
    private int etapa;
    private int precisao;
    private double erroMaximo;

    public ChapaMetalica(int linhas, int colunas, int precisao, double erroMaximo) {
        this.matriz = new double[linhas][colunas];
        this.matrizAuxiliar = new double[linhas][colunas];
        this.etapa = 0;
        this.precisao = precisao;
        this.erroMaximo = erroMaximo;
    }

    public void popularMatrizComValoresIniciais(double esquerda, double direita, double superior, double inferior) {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (j == 0) {
                    this.matriz[i][j] = esquerda;
                }
                if (j == this.matriz[i].length - 1) {
                    this.matriz[i][j] = direita;
                }
                if (i == 0) {
                    this.matriz[i][j] = superior;
                }
                if (i == this.matriz.length - 1) {
                    this.matriz[i][j] = inferior;
                }
            }
        }
    }

    public void popularMatrizAuxiliar() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                this.matrizAuxiliar[i][j] = this.matriz[i][j];
            }
        }
    }

    public void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("  %."+ precisao +"f  ", new BigDecimal(this.matriz[i][j]).setScale(precisao, RoundingMode.HALF_UP).doubleValue());
            }
            System.out.println();
        }
    }

    public void rodarEtapa() {
        this.popularMatrizAuxiliar();
        for (int i = 1; i < this.matriz.length -1; i++) {
            for (int j = 1; j < this.matriz[i].length -1; j++) {
                this.matriz[i][j] = calcularMediaDeTemperaturasDaVizinhanca(i, j);
            }
        }
        this.etapa += 1;
    }

    public double calcularMediaDeTemperaturasDaVizinhanca(int i, int j) {
        return (this.matrizAuxiliar[i-1][j] + this.matrizAuxiliar[i+1][j] + this.matrizAuxiliar[i][j-1] + this.matrizAuxiliar[i][j+1]) / 4;
    }

    public int getEtapa() {
        return this.etapa;
    }

    public double[][] getMatrizAuxiliar() {
        return matrizAuxiliar;
    }

    public double[][] getMatriz() {
        return this.matriz;
    }

    public boolean estaEmEquilibrioTermico() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (comparaTemperatura(i, j)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean comparaTemperatura(int i, int j) {
        double tempMatriz = new BigDecimal(this.matriz[i][j]).setScale(precisao, RoundingMode.HALF_UP).doubleValue();
        double tempMatrizAuxiliar = new BigDecimal(this.matrizAuxiliar[i][j]).setScale(precisao, RoundingMode.HALF_UP).doubleValue();

        return (tempMatriz <= tempMatrizAuxiliar + erroMaximo) && (tempMatriz >= tempMatrizAuxiliar - erroMaximo);
    }
}
