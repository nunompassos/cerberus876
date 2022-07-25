package Investimentos;

import java.util.ArrayList;

public class ClienteArrojado extends PerfilCliente {
  private ArrayList<RendaVariavel> investimentos = new ArrayList<>();


  public void contratarInvestimento(RendaVariavel investimento) {
    this.investimentos.add(investimento);
  }
  
  public ArrayList<RendaVariavel> getCarteiraInvestimentos() {
    return investimentos;
  }
}
