package br.com.letscode;

public class MovimentoPessoa {

    public void andarPe(Pessoa p, int distancia) {
        System.out.println("A pessoa " + p.getNome() + " andou " + distancia + " metros!");
    }

    public void andarCarro(Pessoa p, int distancia) {
        System.out.printf("A pessoa %s ligou o carro e andou %d kms!", p.getNome(), distancia);
    }

}
