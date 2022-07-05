package br.com.letscode.Models.enums;

import java.util.Scanner;

import br.com.letscode.Models.Pessoa;

public enum Sexo {
  MASCULINO(1),
  FEMININO(2);

  int sexo;

  private Sexo(int sexo) {
    this.sexo = sexo;
  }
  static public void printAll() {
    for (Sexo sexo : Sexo.values()) {
      System.out.println(sexo.ordinal() + 1 + " " + sexo.toString());
    }
  }

  public static Sexo setSexo(int estado) {
    for (Sexo sexo : Sexo.values()) {
      if (sexo.ordinal() == estado - 1) {
        return sexo;
      }
    }
    return null;
  }
  
  public static void whileSexoNotNull(Scanner scanner, Pessoa pessoa) {
    while (pessoa.getSexo() == null) {
      System.out.println("Selecione o sexo");
      Sexo.printAll();
      int getSexo = scanner.nextInt();
      pessoa.setSexo(Sexo.setSexo(getSexo));
    }
  }
  public int getSexo() {
    return sexo;
  }
}
