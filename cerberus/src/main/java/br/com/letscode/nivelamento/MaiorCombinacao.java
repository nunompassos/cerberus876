package br.com.letscode.nivelamento;

/**
 * Dado um array de inteiros e um número de combinaçoes, encontre a maior combinaçao de números vizinhos.

    Ex. 1:

    ENTRADA

    array: {15,30,100,50,23}

    numero: 3

    SAIDA

    180, porque a maior combinacao de números 3 seguidos é 30,100 e 50
 */

public class MaiorCombinacao {
    
    public static void main(String[] args) {
        int[] array = {50,1,50,600,100, 50};
        int num = 3;

        MaiorCombinacao maiorCombinacao = new MaiorCombinacao();

        System.out.println(maiorCombinacao.maximoCombinacoes(array, num));        

    }

    public int maximoCombinacoes(int array[], int num) {

        if (num > array.length) {
            return -1;
        }

        int[] combinacoes = new int[num];
        int somaTotal = 0;
        int somaAtual = 0;

        for (int i = 0; i < array.length - num; i++) {
            for (int j = 0; j < combinacoes.length; j++) {
                combinacoes[j] = array[i+1+j];
                somaAtual += combinacoes[j];
            }
            if (somaAtual >= somaTotal) {
                somaTotal = somaAtual;
            }
            somaAtual = 0;

        }
        return somaTotal;
    }
}
