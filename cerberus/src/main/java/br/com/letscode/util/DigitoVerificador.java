package br.com.letscode.util;

public abstract class DigitoVerificador {
	private static final int[] pesos = {1,3,5,9,5};
	public static final int numeroDeDigitos = 5;
	
	public static int calculaDigito(int num) {
		if (String.valueOf(num).length() != numeroDeDigitos) 
			throw new IllegalArgumentException("Número deve ter " + (numeroDeDigitos) + " dígitos");
		int[] digitos = new int[numeroDeDigitos];
		for (int i = 0; i < numeroDeDigitos; i++) {
			digitos[numeroDeDigitos-1-i] = (num / (int) Math.pow(10, i)) % 10;
		}
		int soma = 0;
		for (int i = 0; i < numeroDeDigitos; i++) {
			soma += digitos[i] * pesos[i];
		}
		return soma % 10;
	}

	public static boolean verificaDigito(int numComDigito) {
		if (String.valueOf(numComDigito).length() != numeroDeDigitos + 1) 
		throw new IllegalArgumentException("Número deve ter " + (numeroDeDigitos + 1) + " dígitos");
		
		int digito = numComDigito % 10;
		int num = numComDigito / 10;
		return calculaDigito(num) == digito;
	}

}
