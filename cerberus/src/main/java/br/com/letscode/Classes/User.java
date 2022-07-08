package br.com.letscode.Classes;

import java.util.ArrayList;

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

    // Outros métodos.

    public void minhasContas() {
        System.out.println("\nBem-vindo, " + nome + ". Suas contas existentes são: \n");
        for (int i = 0; i < App.contas.size(); i++) {
            if (App.contas.get(i).getUser().getId() == (id)) {
                System.out.println((App.contas.get(i).toString()));
            }
        }
    }
    
    // public ArrayList<Conta> minhasContas() {
    //     ArrayList<Conta> contasUser = new ArrayList<>();
    //     for (int i = 0; i < App.contas.size(); i++) {
    //         if (App.contas.get(i).getUser().getId() == (id)) {
    //             contasUser.add(App.contas.get(i));
    //             System.out.println(contasUser);
    //         }
    //     }
    //     if (contasUser.size() == 0) {
    //         System.out.println("Você não possui nenhuma conta ainda.");
    //     }
    //     return contasUser;

    // }   
}
