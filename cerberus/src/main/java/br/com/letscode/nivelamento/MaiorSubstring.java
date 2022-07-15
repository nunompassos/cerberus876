package br.com.letscode.nivelamento;

public class MaiorSubstring {
    
    public static void main(String[] args) {
        
        String[] palavras = {"acbda", "fasdlkh", "poiwqd", "zxcqwtop", "qfgophl"};

        encontraMaiorSubstring(palavras);
    }

    private static void encontraMaiorSubstring(String[] palavras) {

        String maiorSubstring = "";
        String substringAtual = "";

        for (String palavra : palavras) {

            char[] palavraToCharArray = palavra.toCharArray();
            char[] substring = new char[palavra.length()];
            substring[0] = palavraToCharArray[0];

            for (int i = 1; i < palavraToCharArray.length; i++) {

                if (palavraToCharArray[i] >= palavraToCharArray[i-1]) {

                    substring[i] = palavraToCharArray[i];

                } else {

                    substringAtual = new String(substring).trim();
                    
                    if (substringAtual.length() > maiorSubstring.length()) {
                    
                        maiorSubstring = substringAtual;
                    }
                    
                    substring = new char[palavra.length()];
                    substring[i] = palavraToCharArray[i];

                }
            }
        }

        System.out.println(maiorSubstring);

    }
    
}
