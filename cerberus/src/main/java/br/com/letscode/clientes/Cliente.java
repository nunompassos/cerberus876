package br.com.letscode.clientes;

public abstract class Cliente {

    private String nome;
    private String numeroDocumento;

    public Cliente(String _nome, String _numeroDocumento) {
        this.nome = _nome;
        this.numeroDocumento = _numeroDocumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public abstract boolean isTaxavel();
}
