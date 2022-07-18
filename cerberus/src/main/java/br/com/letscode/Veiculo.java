package br.com.letscode;

public abstract class Veiculo implements Aceleravel, Ligavel {
  private String cor;
  private int ano;
  private String modelo;
  private boolean isUsed;



  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getModelo() {
    return modelo;
  }
  public void usouUmaVez(){
    this.isUsed = true;
  }
  public boolean getIsUsed(){
    return isUsed;
  }
}
