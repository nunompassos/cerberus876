package br.com.letscode.models;

import java.math.BigDecimal;

import br.com.letscode.Utils.Utils;

public class ContaCorrentePF extends ContaCorrente {
  @Override
  public void sacar(BigDecimal quantidade) {
    boolean saldoIsSuficiente = Utils.saldoIsSuficiente(quantidade, this.getSaldo());
    if (!saldoIsSuficiente) {
      System.out.println("Saldo Insuficiente");
      return;
    }
    this.setSaldo(this.getSaldo().subtract(quantidade));
  }

  @Override
  public void depositar(BigDecimal quantidade) {
    this.setSaldo(this.getSaldo().add(quantidade));
  }

  @Override
  public void transfere(int idConta, BigDecimal valor) {
    ContaCorrente contaATransferir = Utils.findCorrenteById(idConta);
    if (contaATransferir == null) {
      System.out.println("Conta inexistente!!!");
      return;
    }
    this.sacar(valor);
    contaATransferir.depositar(valor);
  }
}
