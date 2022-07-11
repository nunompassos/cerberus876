package br.com.letscode.clientes;

public class ClientePJ extends Cliente{
    
    private String cnpj;
    private TipoDeEmpresa tipo;

    
    public ClientePJ(String nome, String cnpj, TipoDeEmpresa tipo) {
        super(nome);
        this.cnpj = cnpj;
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public TipoDeEmpresa getTipo() {
        return tipo;
    }
    public void setTipo(TipoDeEmpresa tipo) {
        this.tipo = tipo;
    }

}