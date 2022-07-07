package br.com.letscode.Classes;

import br.com.letscode.App;

public class User {
    private int id;
    protected Personalidade tipoPessoa;
    private String nome;

    // construtor
    public User(String nome, String tipoPessoa) {
        this.id = App.users.size();
        this.nome = nome;
        this.tipoPessoa = Personalidade.valueOf(tipoPessoa);
    }
    
    // getters e setters.
    public int getId() {
        return id;
    }
    
    public Personalidade getTipoPessoa() {
        return tipoPessoa;
    }
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
