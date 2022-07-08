package br.com.letscode.models;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Conta {
  private int numeroDaConta;
  private BigDecimal saldo;

  public Conta (){
    this.setNumeroDaConta(new Random().nextInt() % 500);
    this.setSaldo(new BigDecimal(0));
  }

  public int getNumeroDaConta() {
    return numeroDaConta;
  }

  public void setNumeroDaConta(int numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  @Override
  public String toString() {
    return String.format("\n\n------------------\nNumero da conta: %s\n------------------\nSaldo: %s\n------------------\nTipo da conta: %s\n", this.getNumeroDaConta(), this.getSaldo(),
        this.getClass().getSimpleName());
  }

  // public boolean isTransferivel(){
  // String[] interfaces = new String[(this.getClass().getInterfaces().length)];
  // for (int i = 0; i < this.getClass().getInterfaces().length; i++) {
  // interfaces[i] = this.getClass().getInterfaces()[i].getSimpleName();
  // }
  // for (int i = 0; i < interfaces.length; i++) {
  // if (interfaces[i] == "Transferivel") {
  // return true;
  // }
  // }
  // return false;
  // }
}
