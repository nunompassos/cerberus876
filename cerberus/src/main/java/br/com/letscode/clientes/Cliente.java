package br.com.letscode.clientes;

public abstract class Cliente {
    // Definição dos atributos/características
    private String nome;

    // Definição dos métodos/comportamentos
    public Cliente(String nome){
        this.nome = nome;
    }

    public boolean isPessoaJuridica(){
        if(this instanceof ClientePJ){
            return true;
        } else {
            return false;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}
