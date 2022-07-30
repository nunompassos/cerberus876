package br.com.mybank.projetofinal02;

import java.math.BigDecimal;

public class ClientePessoaFisica extends Cliente{
    
    public ClientePessoaFisica(String nome) {
        super(nome,new BigDecimal(0.05), 5);
    }

    public ClientePessoaFisica(String nome, BigDecimal desconto, Integer diariasMinimasParaDesconto) {
        super(nome,desconto, diariasMinimasParaDesconto);
    }
}

