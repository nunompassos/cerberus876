package br.com.letscode;

public class Pessoa {

    private String nome;
    private String apelido;
    private int idade;

    public Pessoa() { }

    public Pessoa(final String _nome, final String _apelido, final int _idade) {
        this.nome = _nome;
        this.apelido = _apelido;
        this.idade = _idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Eu chamo-me " + this.nome + " " + this.apelido + " e tenho " + this.idade + " anos.";
    }
}
