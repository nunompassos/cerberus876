package br.com.letscode.interfaces;

import java.math.BigDecimal;

public interface IRentavel {
  public void rende();

  public final static BigDecimal RENTABILIDADE_ANUAL_POUPANCA_PF = new BigDecimal("0.05");
  public final static BigDecimal RENTABILIDADE_ANUAL_INVESTIMENTO_PF = new BigDecimal("0.1");
  public final static BigDecimal RENTABILIDADE_ANUAL_INVESTIMENTO_PJ = RENTABILIDADE_ANUAL_INVESTIMENTO_PF
      .add(new BigDecimal(("0.02")));
}
