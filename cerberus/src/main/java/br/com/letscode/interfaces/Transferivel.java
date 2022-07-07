package br.com.letscode.interfaces;

import java.math.BigDecimal;

public interface Transferivel {
  public void transfere(int idConta, BigDecimal valor);
}
