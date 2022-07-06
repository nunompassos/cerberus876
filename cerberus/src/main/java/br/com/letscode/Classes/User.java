package br.com.letscode.Classes;
public class User {
    int id;
    String tipoPessoa;
    String nome;

    // construtor
    public User(int id, String nome, String tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }
    // getters e setters.
    public void setTipoPessoa(String tipoPessoa) {
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
