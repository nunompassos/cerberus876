package br.com.letscode.nivelamento;

/**
 * Una dois arrays de inteiros em um único array.
 * Restrições:
 *  Não é permitido uso de Collections ou de java.utils.Arrays
 * Não é permitido o uso de arrays temporários.
 */

public class UnaDoisArrays {
    
    public static void main(String[] args) {
        
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8, 12, 15};

        int[] arrayConsolidado = new int[array1.length + array2.length];

        juntarArrays(array1, array2, arrayConsolidado);

    }

    public static void juntarArrays(int[] array1, int[] array2, int[] arrayConsolidado) {

        // o primeiro passo é juntar um array no outro

        for (int i = 0; i < array1.length; i++) {
            arrayConsolidado[i] = array1[i];
        }

        for (int i = 0, j = array1.length; i < array2.length; i++, j++) {
            arrayConsolidado[j] = array2[i];
        }

        // agora é ordenar esse array

        for (int i = 0; i < arrayConsolidado.length; i++) {
            for (int j = i + 1; j < arrayConsolidado.length; j++) {
                if (arrayConsolidado[j] < arrayConsolidado[i]) {
                    int aux = arrayConsolidado[j];
                    arrayConsolidado[j] = arrayConsolidado[i];
                    arrayConsolidado[i] = aux;
                }
            }
            System.out.println(arrayConsolidado[i]);
        }

    }
}
