package br.com.mybank.db;
import java.util.ArrayList;

import br.com.mybank.models.conta.Conta;
import br.com.mybank.models.exceptions.MensagemErro;

public class MyBankDB {
    private static ArrayList<Conta> myDataBase = new ArrayList<Conta>();

    public static void abrirConta(Conta conta) throws MensagemErro{
        if(myDataBase.contains(conta)){
            throw new MensagemErro("Conta ja existe");
        }
        myDataBase.add(conta);
    }

    public static Conta login(int numero){
        
        for (int i = 0; i < myDataBase.size(); i++) {
            if(myDataBase.get(i).getConta() == numero){
                return myDataBase.get(i);
            }
        }
        throw new RuntimeException("Conta nao encontrada");
    }
}
