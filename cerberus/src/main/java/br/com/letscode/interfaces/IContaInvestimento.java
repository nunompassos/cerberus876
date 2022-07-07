package br.com.letscode.interfaces;

import java.math.BigDecimal;

public interface IContaInvestimento {
  public void aportar(BigDecimal valor);
  public void retirar(BigDecimal valor);
}
