package br.com.letscode.models;

import java.math.BigDecimal;

import br.com.letscode.Utils.Utils;
import br.com.letscode.interfaces.Taxavel;

public class ContaCorrentePJ extends ContaCorrente implements Taxavel {
  @Override
  public void sacar(BigDecimal quantidade) {
    //trocar pq é em cima do valor do saque/transferencia e nao do saldo.
    BigDecimal valorASacar = this.getSaldo().add(this.getSaldo().multiply(Taxavel.tributo));
    boolean saldoIsSuficiente = Utils.saldoIsSuficiente(valorASacar, this.getSaldo());
    if (!saldoIsSuficiente) {
      System.out.println("SaldoInsuficiente");
      return;
    }
    this.setSaldo(this.getSaldo().subtract(valorASacar));
  }

  @Override
  public void depositar(BigDecimal quantidade) {
    this.setSaldo(this.getSaldo().add(quantidade));
  }

  @Override
  public void transfere(int idConta, BigDecimal valor) {
    ContaCorrente contaCorrente = Utils.findCorrenteById(idConta);
    if (contaCorrente == null) {
      System.out.println("Conta inexistente!!!");
    }
    this.sacar(valor);
    contaCorrente.depositar(valor);
  }
}
