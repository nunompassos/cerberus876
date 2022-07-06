package br.com.letscode.Classes;
public class User {
    int id;
    Personalidade tipoPessoa;
    String nome;

    // construtor
    public User(int id, String nome, Personalidade tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }
    // getters e setters.
    public void setTipoPessoa(Personalidade tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
