package TiposDeAplicacoes;
import java.math.BigDecimal;
 
public class CDB extends RendaFixa{
    private BigDecimal saldoCDB = new BigDecimal("0");

    public BigDecimal investirCDB(BigDecimal valor) {
        this.saldoCDB = investir(valor);
        return saldoCDB;
    }
}
