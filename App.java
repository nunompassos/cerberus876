package Investimentos;

public class App {
  public static void main(String[] args) {
    var conservador = new ClienteConservador();
    // método contratarInvestimento adiciona na lista de investimentos do cliente
    conservador.contratarInvestimento(new CDB());
    conservador.contratarInvestimento(new Tesouro());

    conservador.contratarInvestimento(new Acao());// ERRO de compilação
    for (Investimento i : conservador.getCarteiraInvestimentos()) {
      System.out.println(i);
    }

    var arrojado = new ClienteArrojado();
    arrojado.contratarInvestimento(new Acao());
    arrojado.contratarInvestimento(new FundoImobiliario());

    arrojado.contratarInvestimento(new Tesouro());// ERRO de compilação
    for (Investimento i : arrojado.getCarteiraInvestimentos()) {
      System.out.println(i);
    }
  }
}