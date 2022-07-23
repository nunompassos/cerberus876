package br.com.letscode.solid.single;

public class ProcessadorLivro {

    public boolean encontrarPalavra(final Livro livro, final String palavra) {
        return livro.getTexto().contains(palavra);
    }

    public void substituiPalavra(final Livro livro, final String palavraAntiga, final String palavraNova) {
        livro.setTexto(livro.getTexto().replaceAll(palavraAntiga, palavraNova));
    }

}
