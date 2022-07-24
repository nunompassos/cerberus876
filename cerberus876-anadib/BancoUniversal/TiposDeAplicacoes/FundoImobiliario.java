package TiposDeAplicacoes;
import java.math.BigDecimal;

public class FundoImobiliario extends RendaVariavel{
    BigDecimal saldo = new BigDecimal("0");

    public BigDecimal investirFundoImobiliario(BigDecimal valor) {
        this.saldo = investir(valor);
        return saldo;
    }

}
