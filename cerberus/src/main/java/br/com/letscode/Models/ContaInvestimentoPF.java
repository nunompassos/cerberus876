package br.com.letscode.models;

import java.math.BigDecimal;

import br.com.letscode.interfaces.IRentavel;

public class ContaInvestimentoPF extends ContaInvestimento {

  public ContaInvestimentoPF(ContaCorrentePF titular){
    this.setNumeroDaConta(titular.getNumeroDaConta()); 
  }

  @Override
  public void aportar(BigDecimal valor) {
    this.getTitular().sacar(valor);
    this.setSaldo(valor);
  }
  @Override
  public void retirar(BigDecimal valor) {
    this.setSaldo(this.getSaldo().subtract(valor));
  }
  @Override
  public void rende() {
    this.setSaldo(this.getSaldo().add(this.getSaldo().multiply(IRentavel.RENTABILIDADE_ANUAL_INVESTIMENTO_PF)));
  }
}
