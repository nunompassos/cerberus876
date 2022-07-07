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

  public void sacar(BigDecimal quantidade) {
    boolean saldoIsSuficiente = Utils.saldoIsSuficiente(quantidade, this.getSaldo());
    if (saldoIsSuficiente) {
      System.out.println("Saldo Insuficiente");
      return;
    }
    this.setSaldo(this.getSaldo().subtract(quantidade));
  }

  public void depositar(BigDecimal quantidade) {
    this.setSaldo(this.getSaldo().add(quantidade));
  }

  @Override
  public void rende() {
    this.setSaldo(this.getSaldo().add(this.getSaldo().add(IRentavel.RENTABILIDADE_ANUAL_POUPANCA_PF)));
  }
  @Override
  public void transfere(int idConta, BigDecimal valor) {
    ContaPoupanca conta = Utils.findPoupancaById(idConta);
    if (conta == null) {
      System.out.println("Conta inexistente!");
      return;
    }
    this.sacar(valor);
    conta.depositar(valor);
  }
}
