package br.com.letscode;

public interface Pessoa {

    default void andar(int mt) {
        System.out.println("Andei " + mt + " metros!");
    }
}
