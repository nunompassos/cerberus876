package br.com.letscode;

public class Mota extends Veiculo{
  @Override
  public void giraAChave() {
    System.out.println("Motorzinho ligado");
    System.out.println("vrim vrim");
  }
  @Override
  public void acelera() {
    System.out.println("celerando");
    System.out.println("Ran dan dan dan");
  }
}
