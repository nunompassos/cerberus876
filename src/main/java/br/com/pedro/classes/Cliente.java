package br.com.pedro.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome) throws ClienteException {
        if (nome == null) {
            throw new ClienteException("Nome não pode ser null");
        }
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public String getNome() {
        return nome;
    }
}
