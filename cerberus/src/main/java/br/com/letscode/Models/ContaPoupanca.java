package br.com.letscode.models;


import java.math.BigDecimal;

import br.com.letscode.interfaces.IRentavel;
import br.com.letscode.interfaces.Sacavel;
import br.com.letscode.interfaces.Transferivel;

public abstract class ContaPoupanca extends Conta implements Sacavel, IRentavel, Transferivel {
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
