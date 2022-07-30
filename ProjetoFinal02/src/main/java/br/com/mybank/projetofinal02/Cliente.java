package br.com.mybank.projetofinal02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Cliente {
    private String nome;
    private BigDecimal taxaDesconto = BigDecimal.ZERO; 
    private Integer diariasMinimasParaDesconto;
     
    public Cliente(String nome, BigDecimal taxaDesconto, Integer diariasMinimasParaDesconto){
        this.nome = nome;
        this.taxaDesconto = taxaDesconto;
        this.diariasMinimasParaDesconto = diariasMinimasParaDesconto;
    }

    public BigDecimal getTaxaDesconto(Integer diarias) {
        if(diarias > diariasMinimasParaDesconto) {
            return taxaDesconto.setScale(2, RoundingMode.DOWN);
        }
        return BigDecimal.ZERO;
    }

    public void setTaxaDesconto(BigDecimal desconto) {
        this.taxaDesconto = desconto;
    }         

    public String getNome() {
        return nome;
    }
      
    public void setNome(String nome) {
        this.nome = nome;
    }
      
    @Override
        public String toString() {
        return this.nome;
    }
}
