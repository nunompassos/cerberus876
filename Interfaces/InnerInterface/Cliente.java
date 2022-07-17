import java.math.BigDecimal;

public class Cliente {    
    private BigDecimal saldo;  

    public void setSaldo(BigDecimal saldo) {
       this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
     }
    
    public interface OperacaoSaldoAtualizado{
        public BigDecimal saldoAtualizado();
    }
}




