package br.com.mybank.projetofinal02;
import java.math.BigDecimal;

public class Aluguel {
    BigDecimal valorTotal = BigDecimal.ZERO;
    Integer diarias;
    Cliente cliente;
    Veiculo veiculo;
   
    public Aluguel (Cliente cliente, Veiculo veiculo, Integer diarias){
       this.cliente = cliente;
       this.veiculo = veiculo;
       this.diarias = diarias;
    }

    public void calculaAluguel(){
      valorTotal = new BigDecimal(this.diarias).multiply(veiculo.getDiariaAluguel()).multiply
        (new BigDecimal(1).subtract(cliente.getTaxaDesconto(diarias)));
      System.out.printf("%s alugou veículo por %d dias, com diária de %.2f, com valor total de R$ %.2f.\n",  cliente.getNome(),
        diarias, veiculo.getDiariaAluguel(), valorTotal);
    }
}
