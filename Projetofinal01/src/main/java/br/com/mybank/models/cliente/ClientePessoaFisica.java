package br.com.mybank.models.cliente;

public class ClientePessoaFisica extends Cliente{
  private String cpf;

  public ClientePessoaFisica(String nome) {
    super(nome);
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }  
}
