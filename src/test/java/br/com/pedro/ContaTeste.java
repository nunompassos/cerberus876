package br.com.pedro;

import java.math.BigDecimal;
import java.util.Random;

import br.com.pedro.classes.Agencia;
import br.com.pedro.classes.AgenciaException;
import br.com.pedro.classes.Conta;
import br.com.pedro.classes.ContaException;
import br.com.pedro.classes.ClientePessoaFisica.EstadoCivil;

public class ContaTeste {
    
    public static void main(String[] args) throws ContaException, AgenciaException {
        
        // Agencia a1 = new Agencia(2811, "Praia de Boa Viagem");
        // Conta c1 = new Conta(a1, 8214108);
        // Conta c2 = new Conta(a1, 555);
        // System.out.println(Agencia.getAgencia(2811));
        // System.out.println(a1.getConta(8214108));
        
        // c1.depositar(BigDecimal.valueOf(200));
        // // c1.sacar(BigDecimal.valueOf(200.00));
        // c1.transferir(2811, 555, BigDecimal.valueOf(55));
        // System.out.println(a1.getConta(8214108));
        // System.out.println(a1.getConta(555));
        // System.out.println(a1.getConta(555).investir(BigDecimal.valueOf(55), 360));

        EstadoCivil.imprimirOpcoes();
        System.out.println(EstadoCivil.values().length);
    }
}