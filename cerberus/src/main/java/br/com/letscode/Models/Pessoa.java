package br.com.letscode.Models;

import java.math.BigDecimal;

import br.com.letscode.Models.enums.EstadoCivil;
import br.com.letscode.Models.enums.Sexo;

public class Pessoa {
  private String nome;
  private int idade;
  private Sexo sexo;
  private String endereco;
  private EstadoCivil estadoCivil;
  private BigDecimal altura;
  private BigDecimal peso;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Sexo getSexo() {
    return sexo;
  }

  public void setSexo(Sexo sexo) {
    this.sexo = sexo;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public BigDecimal getAltura() {
    return altura;
  }

  public void setAltura(BigDecimal altura) {
    this.altura = altura;
  }

  public BigDecimal getPeso() {
    return peso;
  }

  public void setPeso(BigDecimal peso) {
    this.peso = peso;
  }
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Pessoa{" +
    "Nome da pessoa: " + nome +
    ", Idade: " + idade + '\'' +
    ", Altura: " + altura +
    ", Endereço: " + endereco +
    ", Peso: " + peso +
    ", Sexo: " + sexo +
    ", Estado civil: " + estadoCivil +
    '}';
  }
}
