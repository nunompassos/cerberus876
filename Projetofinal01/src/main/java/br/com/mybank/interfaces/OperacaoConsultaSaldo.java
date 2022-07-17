package br.com.mybank.interfaces;
import java.math.BigDecimal;


public interface OperacaoConsultaSaldo {

  /**
   * Implementar na conta corrente e conta poupanca
   */
  public BigDecimal consultarSaldo();
}
