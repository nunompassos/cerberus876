package br.com.letscode.nivelamento;

import java.util.ArrayList;

public class ConversaoMoedas {
	
	  public static void main(String[] args) {
		    ArrayList<String> moedas = new ArrayList<String>();
		    moedas.add("AUD");
		    moedas.add("0.6944");
		    moedas.add("USD");
		    moedas.add("5.15");
		    moedas.add("BRL");
		    moedas.add("0.18");
		    moedas.add("EUR");
		    moedas.add("0.86");
		    moedas.add("GBP");
		    
		    String entrada = "GBP - USD";
		    
		    converteMoeda(entrada, moedas);
		    		    
		    System.out.println("\n\n"+moedas);
		    
		  }
	  
	  public static void converteMoeda(String input, ArrayList<String> moedas) {
		  
		  String moeda1 = input.substring(0, 3);
		  String moeda2 = input.substring(6, 9);
		  int posicaoMoeda1 = moedas.indexOf(moeda1);
		  int posicaoMoeda2 = moedas.indexOf(moeda2);
		  Double saida = 1.0;
		  
		  if(posicaoMoeda1 < posicaoMoeda2) {
			  for (int i = posicaoMoeda1+2; i<= posicaoMoeda2; i += 2) {
				  saida = saida * Double.parseDouble(moedas.get(i-1));
			  }
		  } else if(posicaoMoeda1 > posicaoMoeda2){
			  for (int i = posicaoMoeda1-2; i>= posicaoMoeda2; i -= 2) {
				  saida = saida / Double.parseDouble(moedas.get(i+1));
			  }
		  }   
		   
		  System.out.printf("%s - %s: %.2f", moeda1, moeda2, saida);
		  
	  }
	  
}
