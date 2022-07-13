package br.com.letscode.veiculos.subveiculos;

import br.com.letscode.Automovel;

public class Carro implements Automovel {
    @Override
    public void buzinar() {
        System.out.println("POOOOOOOOOOO");
    }

    @Override
    public void ligarRadio(String s) {
        System.out.println("Música");
    }

    @Override
    public void ligarMotor() {
        System.out.println("ZZZZZZZZZZZZZZ");

    }

    public void parar() {
        System.out.println("Parei");
    }

    @Override
    public void abrirPortas() {
        System.out.println("Abrir uma porta!");
    }
}
