package br.com.letscode.models;

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
  // public boolean isTransferivel(){
  //   String[] interfaces =  new String[(this.getClass().getInterfaces().length)];
  //   for (int i = 0; i < this.getClass().getInterfaces().length; i++) {
  //     interfaces[i] = this.getClass().getInterfaces()[i].getSimpleName();
  //   }
  //   for (int i = 0; i < interfaces.length; i++) {
  //     if (interfaces[i] == "Transferivel") {
  //       return true;
  //     }
  //   }
  //   return false;
  // }
}
