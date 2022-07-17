import java.math.BigDecimal;

public class TestInnerInterface {
    private static BigDecimal bonus = new BigDecimal("100.00");
    private static BigDecimal saldo = new BigDecimal("200.00");
    public static void main(String[] args) {

      ClienteEspecial cl = new ClienteEspecial(bonus);
      cl.setSaldo(saldo);
      cl.saldoAtualizado();
      
  }
}