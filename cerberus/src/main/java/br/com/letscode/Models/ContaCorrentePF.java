package br.com.letscode.models;

import java.math.BigDecimal;

import br.com.letscode.interfaces.Transferivel;

public class ContaCorrentePF extends ContaCorrente {
  @Override
  public void sacar(BigDecimal quantidade) {
    if (quantidade.compareTo(this.getSaldo()) == 1) {
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
    ContaCorrente contaATransferir = contasCorrentes.stream()
                  .filter(conta -> (conta.getNumeroDaConta() == idConta))
                  .findAny()
                  .orElse(null);
    if (contaATransferir == null) {
      System.out.println("Conta inexistente!!!");
      return;
    }
    this.sacar(valor);
    contaATransferir.depositar(valor);
  }
}
