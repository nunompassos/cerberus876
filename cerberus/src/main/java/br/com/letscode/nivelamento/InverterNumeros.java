package br.com.letscode.nivelamento;

public class InverterNumeros {
    
    public static void main(String[] args) {
        
        System.out.println(inverter(-4768));

    }

    public static Integer inverter(Integer numero) {

        Integer numeroInvertido = 0;
        
        while (numero != 0) {
            Integer resto = numero % 10;
            numeroInvertido = numeroInvertido * 10 + resto;
            numero = numero / 10;
        }
        return numeroInvertido;

    }
}
