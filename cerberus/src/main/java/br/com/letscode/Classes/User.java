package br.com.letscode.Classes;

import br.com.letscode.App;

public class User {
    int id;
    String tipoPessoa;
    String nome;

    // construtor
    public User(String nome, String tipoPessoa) {
        this.id = App.users.size();
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    // getters e setters.
    public int getId() {
        return id;
    }

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
