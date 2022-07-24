package TiposDeAplicacoes;

import java.math.BigDecimal;

public class Tesouro extends RendaFixa {
    private BigDecimal saldoTesouro = new BigDecimal("0");

    public BigDecimal investirTesouro(BigDecimal valor) {
        this.saldoTesouro = investir(valor);
        return saldoTesouro;
    }


}
