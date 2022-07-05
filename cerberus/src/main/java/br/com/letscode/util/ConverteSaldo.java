package br.com.letscode.util;

public class ConverteSaldo {
	public static String comCifrao(long valor) {
		return "R$ " + semCifrao(valor);
	}

	public static String semCifrao(long valor) {
		String digitos = String.valueOf(valor);
		String reais = digitos.substring(0, digitos.length() - 2);
		String centavos = digitos.substring(digitos.length() - 2, digitos.length());
		return reais + ',' + centavos;
	}
}