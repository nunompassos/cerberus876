package br.com.letscode.Models;


import java.math.BigDecimal;

import br.com.letscode.interfaces.Sacavel;

public abstract class ContaPoupanca extends Conta implements Sacavel {


  public void sacar(BigDecimal quantidade) {
    if (quantidade.compareTo(this.getSaldo()) == 1) {
      System.out.println("Saldo Insuficiente");
      return;
    }
    this.setSaldo(this.getSaldo().subtract(quantidade));
  }
  public void depositar(BigDecimal quantidade) {
    this.setSaldo(this.getSaldo().add(quantidade));
  }
}
