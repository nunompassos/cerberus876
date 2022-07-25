package Investimentos;

import java.util.ArrayList;
import java.util.List;

public abstract class PerfilCliente {
  private String nome;
  private int idade;

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

}