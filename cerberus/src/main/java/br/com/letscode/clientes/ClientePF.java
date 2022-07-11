package br.com.letscode.clientes;

public class ClientePF extends Cliente {
    
    private String cpf;
    private int idade;

    public ClientePF(String nome, String cpf, int idade) {
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
