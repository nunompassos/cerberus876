package Investimentos;

import java.util.ArrayList;

public class ClienteConservador extends PerfilCliente {

  private ArrayList<RendaFixa> investimentos = new ArrayList<>();

  public void contratarInvestimento(RendaFixa investimento) {
    this.investimentos.add(investimento);
  }

  public ArrayList<RendaFixa> getCarteiraInvestimentos() {
    return investimentos;
  }
}
