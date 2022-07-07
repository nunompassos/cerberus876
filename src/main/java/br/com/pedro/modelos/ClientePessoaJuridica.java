package br.com.pedro.modelos;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) throws ClienteException {
        super(nome);
        if (cnpj == null) {
            throw new ClienteException("CNPJ não pode ser null");
        }
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Empresa ........: " + this.getNome() + "\n"
                + "CNPJ ...........: " + this.cnpj;
    }
}
