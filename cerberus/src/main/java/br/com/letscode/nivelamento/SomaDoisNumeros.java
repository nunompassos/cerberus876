package br.com.letscode.nivelamento;

public class SomaDoisNumeros {
    
    public static void main(String[] args) {
        
        int[] numeros = {2, 4, 7, 8, 12};

        int alvo = 2;

        int[] indices = somaDoisNumeros(numeros, alvo);

        System.out.printf("{%d, %d}", indices[0], indices[1]);

    }

    public static int[] somaDoisNumeros(int[] numeros, int alvo) {

        int[] indices = new int[2];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == alvo) {
                indices[0] = i;
                break;
            }


            
        }

        return indices;

    }
}
