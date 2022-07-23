package br.com.letscode.solid.single;

import java.io.File;

public class ImpressoraLivro {

    public void imprimirConsola(final Livro l) {
        System.out.println(l.getTexto());
    }

    public void imprimirFicheiro(final Livro l) {
        File f = new File("C:/" + l.getTitulo() + ".txt");
    }
}
