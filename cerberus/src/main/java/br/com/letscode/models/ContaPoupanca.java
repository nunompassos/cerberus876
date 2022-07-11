package br.com.letscode.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.letscode.Utils.Utils;
import br.com.letscode.interfaces.IRentavel;
import br.com.letscode.interfaces.Sacavel;
import br.com.letscode.interfaces.Transferivel;

public class ContaPoupanca extends Conta implements Sacavel, IRentavel, Transferivel {
  public static List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
  private BigDecimal limite;

  public ContaPoupanca(){
    super();
    this.limite = new BigDecimal(0);
  }
  public void sacar(BigDecimal quantidade) {
    boolean saldoIsSuficiente = Utils.saldoIsSuficiente(quantidade, this.getSaldo());
    if (!saldoIsSuficiente) {
      System.out.println("Saldo Insuficiente");
      return;
    }
    BigDecimal saque = this.getSaldo().subtract(quantidade);
    System.out.println(saque);
    this.setSaldo(saque);
  }

  public void depositar(BigDecimal quantidade) {
    this.setSaldo(this.getSaldo().add(quantidade));
  }

  @Override
  public void rende() {
    this.setSaldo(this.getSaldo().add(this.getSaldo().multiply(IRentavel.RENTABILIDADE_ANUAL_POUPANCA_PF)));
  }

  @Override
  public void transfere(int idConta, BigDecimal valor) {
    ContaPoupanca conta = Utils.findPoupancaById(idConta);
    System.out.println(conta);
    if (conta == null) {
      System.out.println("Conta inexistente!");
      return;
    }
    this.sacar(valor);
    conta.depositar(valor);
  }

  public void setLimite(BigDecimal limite) {
    this.limite = limite;
  }

  public BigDecimal getLimite() {
    return limite;
  }
  @Override
  public String toString() {
    return super.toString() + String.format("Limite: %s\n", this.getLimite());
  }
}
