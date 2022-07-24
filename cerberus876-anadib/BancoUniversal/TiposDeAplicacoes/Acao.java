package TiposDeAplicacoes;

import java.math.BigDecimal;

public class Acao extends RendaVariavel {
    BigDecimal saldo = new BigDecimal("0");

    public BigDecimal investirAcao(BigDecimal valor) {
        this.saldo = investir(valor);
        return saldo;
    }
}   
