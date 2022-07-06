package br.com.letscode.Models;

import java.math.BigDecimal;

public abstract class Conta {
  private int numeroDaConta;
  private Pessoa titular;
  private BigDecimal saldo;
  private BigDecimal limite;

  public int getNumeroDaConta() {
    return numeroDaConta;
  }

  public void setNumeroDaConta(int numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public Pessoa getTitular() {
    return titular;
  }

  public void setTitular(Pessoa titular) {
    this.titular = titular;
  }

  public void setLimite(BigDecimal limite) {
    this.limite = limite;
  }

  public BigDecimal getLimite() {
    return limite;
  }

  public void sacar(BigDecimal quantidade) {
    if (quantidade.compareTo(saldo) == 1) {
      System.out.println("Saldo Insuficiente");
      return;
    }
    this.saldo.subtract(quantidade);
  }

  public void depositar(BigDecimal quantidade) {
    this.saldo.add(quantidade);
  }
  public BigDecimal getSaldo() {
    return saldo;
  }
}
