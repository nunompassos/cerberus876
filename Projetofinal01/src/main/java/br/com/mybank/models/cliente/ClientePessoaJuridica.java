package br.com.mybank.models.cliente;

public class ClientePessoaJuridica extends Cliente{
  public ClientePessoaJuridica(String nome) {
    super(nome);
  }

  private String cnpj;

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
}
