package br.com.letscode;

public class Automovel extends Veiculo {
  @Override
  public void giraAChave() {
    System.out.println("Motor ligado...");
    System.out.println("vrum vrum");
  }
  @Override
  public void acelera() {
    System.out.println("celerando");
    System.out.println("run dun dun dun dun ");
  }
}
