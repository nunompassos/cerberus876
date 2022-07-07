package br.com.letscode.models;


import java.util.ArrayList;
import java.util.List;

import br.com.letscode.interfaces.IContaInvestimento;
import br.com.letscode.interfaces.IRentavel;

public abstract class ContaInvestimento extends Conta implements IRentavel, IContaInvestimento {
  public static List<ContaInvestimento> contas = new ArrayList<ContaInvestimento>();
}
