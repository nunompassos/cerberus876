package br.com.mybank.projetofinal02;

import java.math.BigDecimal;

public abstract class Veiculo {
    BigDecimal diariaAluguel = BigDecimal.ZERO;

    public Veiculo(BigDecimal diariaAluguel) {
        this.diariaAluguel = diariaAluguel;
    }
    
    public BigDecimal getDiariaAluguel() {
        return this.diariaAluguel;
    }
    public void setDiariaAluguel(BigDecimal diariaAluguel) {
        this.diariaAluguel = diariaAluguel;
    }
}
