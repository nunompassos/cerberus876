package br.com.letscode.Models;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.letscode.Models.enums.EstadoCivil;
import br.com.letscode.Models.enums.Sexo;
import br.com.letscode.Utils.Utils;

public class Pessoa {
  private String nome;
  private int idade;
  private String endereco;

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

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  private EstadoCivil estadoCivil;
  private BigDecimal altura;
  private BigDecimal peso;
  private Sexo sexo;

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

  public Sexo getSexo() {
    return sexo;
  }

  public void setSexo(Sexo sexo) {
    this.sexo = sexo;
  }

  public static Pessoa createPessoa() {
    Scanner scanner = new Scanner(System.in);
    Pessoa pessoa = new Pessoa();
    pessoa.setAltura(Utils.checkNumber(pessoa.getAltura(), scanner, "Altura em m²: "));
    EstadoCivil.whileEstadoCivilNotNull(scanner, pessoa);
    Sexo.whileSexoNotNull(scanner, pessoa);
    pessoa.setIdade(Utils.checkNumber(pessoa.getIdade(), scanner, "Idade: "));
    System.out.println("Nome: ");
    pessoa.setNome(scanner.nextLine());
    pessoa.setPeso(Utils.checkNumber(pessoa.getPeso(), scanner, "Peso: "));
    while (pessoa.getEndereco() == "" || pessoa.getEndereco() == null) {
      System.out.println("Endereço: ");
      pessoa.setEndereco(scanner.nextLine());
    }
    System.out.println(pessoa.toString());
    scanner.close();
    return pessoa;
  }
}
