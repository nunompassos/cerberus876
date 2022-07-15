package br.com.letscode.nivelamento;

public class LetrasX {
    
    public static void main(String[] args) {
        String sequencia = "1XXX7frdts2XXX7xxbl2XXXeee5";
        
        System.out.println(temStringEntreDoisNumerosQueSomamOito(sequencia));
        
    }

    public static boolean temStringEntreDoisNumerosQueSomamOito(String sequencia) {

        String subSequencia = sequencia;
        String alvo = "XXX";
        int posicaoAlvo = subSequencia.indexOf(alvo);

        while (posicaoAlvo != -1) {
            try {
                char charAntesDoAlvo = subSequencia.charAt(posicaoAlvo - 1);
                char charDepoisDoAlvo = subSequencia.charAt(posicaoAlvo + alvo.length());
                int numeroAntesDoAlvo = converteCharParaInt(charAntesDoAlvo);
                int numeroDepoisDoAlvo = converteCharParaInt(charDepoisDoAlvo);
                
                if (numeroAntesDoAlvo + numeroDepoisDoAlvo == 8) {
                    return true;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                continue;
            } finally {
                subSequencia = subSequencia.substring(posicaoAlvo + 1);
                posicaoAlvo = subSequencia.indexOf(alvo);
            }
        }
        return false;
    }

    private static int converteCharParaInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}
