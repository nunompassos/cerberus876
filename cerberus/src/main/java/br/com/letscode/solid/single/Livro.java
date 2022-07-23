package br.com.letscode.solid.single;

import java.io.File;

public class Livro {
    private final String titulo;
    private String autor;
    private String texto;

    public Livro(final String _titulo, final String _autor, final String _texto) {
        this.titulo = _titulo;
        this.autor = _autor;
        this.texto = _texto;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(final String texto) {
        this.texto = texto;
    }

    public boolean existePalavra(final String palavra) {
        return this.texto.contains(palavra);
    }

    public void substituiPalavra(final String palavraAntiga, final String novaPalavra) {
        this.texto.replaceAll(palavraAntiga, novaPalavra);
    }
}
