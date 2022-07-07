package br.com.letscode.Models;

import java.math.BigDecimal;

public abstract class Conta {
  private int numeroDaConta;
  private BigDecimal saldo;
  private BigDecimal limite;

  public int getNumeroDaConta() {
    return numeroDaConta;
  }

  public void setNumeroDaConta(int numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public void setLimite(BigDecimal limite) {
    this.limite = limite;
  }

  public BigDecimal getLimite() {
    return limite;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }
}
