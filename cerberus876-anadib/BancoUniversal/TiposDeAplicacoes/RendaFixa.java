package TiposDeAplicacoes;

import java.math.BigDecimal;
import interfaces.investimento;

public class RendaFixa implements investimento{
    BigDecimal saldo = new BigDecimal("0");
 
    @Override
    public BigDecimal investir(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        return this.saldo;
    }
}
