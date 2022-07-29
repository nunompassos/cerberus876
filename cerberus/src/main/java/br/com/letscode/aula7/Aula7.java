package br.com.letscode.aula7;

public class Aula7 {

    public static void main(String[] args) {
        DesenvolvedorBe desenvolvedor = new DesenvolvedorJava();

        ServicoDesenvolvedor sd = new ServicoDesenvolvedorBe(desenvolvedor);

        sd.desenvolvedorATrabalhar();
    }

}
