package br.com.letscode.clientes;

public enum TipoDeEmpresa {
    SA("Sociedade Anônima"),
    LTDA("Sociedade Limitada"),
    MEI("Microempreendedor Individual"),
    EIRELI("Empresa individual de responsabilidade limitada");

    private String tipoDeEmpresa;
    TipoDeEmpresa(String tipoDeEmpresa){
        this.tipoDeEmpresa = tipoDeEmpresa;
    }

    public String getTipoDeEmpresa(){
        return this.tipoDeEmpresa;
    }
}
