package br.com.pedro;

import java.math.BigDecimal;

import br.com.pedro.classes.Agencia;
import br.com.pedro.classes.AgenciaException;
import br.com.pedro.classes.ClienteException;
import br.com.pedro.classes.ContaException;
import br.com.pedro.classes.ContaCorrentePessoaJuridica;
import br.com.pedro.classes.ClientePessoaJuridica;

public class ContaPessoaJuridicaTeste {
    
    public static void main(String[] args) throws ContaException, AgenciaException, ClienteException {

        Agencia agencia = new Agencia(2811, "Praia de Boa Viagem");
        ClientePessoaJuridica empresa1 = new ClientePessoaJuridica("MyBank", "000.000.001-0001");
        ClientePessoaJuridica empresa2 = new ClientePessoaJuridica("YourBank", "000.000.002-0001");
        ContaCorrentePessoaJuridica pj1 = new ContaCorrentePessoaJuridica(agencia, 26448, empresa1);
        ContaCorrentePessoaJuridica pj2 = new ContaCorrentePessoaJuridica(agencia, 26449, empresa2);

        System.out.println(pj1);
        pj1.depositar(BigDecimal.valueOf(3000));
        // System.out.println(pj);
        // try {
        //     pj.sacar(BigDecimal.valueOf(2850));
        // } catch (ContaException e) {
        //     System.out.println(e.getMessage());;
        // }
        // System.out.println(pj);

        // try {
        //     agencia.getConta(26448).sacar(BigDecimal.valueOf(2850));
        // } catch (ContaException e) {
        //     System.out.println(e.getMessage());;
        // }

        // try {
        //     agencia.getConta(26448).transferir(2811, 26449, BigDecimal.valueOf(500));
        // } catch (ContaException e) {
        //     System.out.println(e.getMessage());
        // }

        // System.out.println(pj1.getSaldo());
        // System.out.println(pj2.getSaldo());

        System.out.println(pj1);
        // System.out.println(agencia.getConta(26448).investir(BigDecimal.valueOf(3000), 360));
    }
}
