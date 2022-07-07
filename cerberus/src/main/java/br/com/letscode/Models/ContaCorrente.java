package br.com.letscode.models;


import java.util.ArrayList;
import java.util.List;

import br.com.letscode.interfaces.Sacavel;
import br.com.letscode.interfaces.Transferivel;


public abstract class ContaCorrente extends Conta implements Sacavel, Transferivel {
  public static List<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
}
