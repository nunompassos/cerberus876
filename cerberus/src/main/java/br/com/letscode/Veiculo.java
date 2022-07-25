package br.com.letscode;

import java.math.BigDecimal;

public abstract class Veiculo {

    private BigDecimal precoBaseDiaria;

    public Veiculo(BigDecimal precoBaseDiaria) {
        this.precoBaseDiaria = precoBaseDiaria;
    }

    public BigDecimal getPrecoBaseDiaria() {
        return precoBaseDiaria;
    }

}
