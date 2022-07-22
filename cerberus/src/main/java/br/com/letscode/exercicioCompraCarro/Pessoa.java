package br.com.letscode.exercicioCompraCarro;

public class Pessoa {
    
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.nome + ", que tem " + this.idade + "anos";
    }

    public int getIdade() {
        return this.idade;
    }

}
