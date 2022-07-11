package br.com.letscode.models;

import java.math.BigDecimal;

import br.com.letscode.Utils.Utils;
import br.com.letscode.interfaces.IRentavel;

public class ContaInvestimentoPJ extends ContaInvestimento {

  public ContaInvestimentoPJ(ContaCorrentePJ titular) {
    this.setTitular(titular);
    this.setNumeroDaConta(titular.getNumeroDaConta());
  }

  @Override
  public void aportar(BigDecimal valor) {
    this.getTitular().sacar(valor);
    this.setSaldo(valor);
  }

  @Override
  public void retirar(BigDecimal valor) {
    boolean saldoIsSuficiente = Utils.saldoIsSuficiente(valor,this.getSaldo());
    if (!saldoIsSuficiente) {
      System.out.println("Saldo insuficiente!");
      return;
    }
    
    this.setSaldo(this.getSaldo().subtract(valor));
    this.getTitular().depositar(valor);
  }

  @Override
  public void rende() {
    this.setSaldo(this.getSaldo().add(this.getSaldo().multiply(IRentavel.RENTABILIDADE_ANUAL_INVESTIMENTO_PJ)));
  }
}
