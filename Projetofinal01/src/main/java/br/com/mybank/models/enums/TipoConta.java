package br.com.mybank.models.enums;

public enum TipoConta{
    FISICA("Conta Pessoal"),
    JURIDICA("Conta Empresarial");
    
    String tipo;
    
    TipoConta(String tp){
        tipo = tp;
    }   
    
    public static TipoConta getTipo(String opcao){
        TipoConta item = TipoConta.valueOf(opcao);
        System.out.println("Tipo de conta é " + item);
        return item;
    }
}
