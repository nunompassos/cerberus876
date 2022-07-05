package br.com.letscode.Models.enums;

import java.util.Scanner;

import br.com.letscode.Models.Pessoa;

public enum EstadoCivil {
  SOLTEIRO(1),
  CASADO(2),
  DIVORCIADO(3),
  VIUVO(4);

  int estado;

  private EstadoCivil(int estado) {
    this.estado = estado;
  }

  static public void printAll() {
    for (EstadoCivil estadoCivil : EstadoCivil.values()) {
      System.out.println(estadoCivil.ordinal() + 1 + " " + estadoCivil.toString());
    }
  }

  public static EstadoCivil setEstado(int estado) {
    for (EstadoCivil estadoCivil : EstadoCivil.values()) {
      if (estadoCivil.ordinal() == estado - 1) {
        System.out.println("Estado civil em sucesso");
        return estadoCivil;
      }
    }
    return null;
  }
  
  public static void whileEstadoCivilNotNull(Scanner scanner, Pessoa pessoa) {
    while (pessoa.getEstadoCivil() == null) {
      System.out.println("Selecione o estado civil");
      EstadoCivil.printAll();
      int getEstadoCivil = scanner.nextInt();
      pessoa.setEstadoCivil(EstadoCivil.setEstado(getEstadoCivil));
    }
  }

  public int getEstado() {
    return estado;
  }
}
