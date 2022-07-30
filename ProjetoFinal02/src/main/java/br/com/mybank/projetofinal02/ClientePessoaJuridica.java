package br.com.mybank.projetofinal02;

import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente{
     
    public ClientePessoaJuridica(String nome) {
        super(nome,new BigDecimal(0.10), 3);
    }

    public ClientePessoaJuridica(String nome, BigDecimal desconto, Integer diariasMinimasParaDesconto) {
        super(nome,desconto, diariasMinimasParaDesconto);
        }
   
}    
