package br.com.pedro.classes;

import br.com.pedro.classes.ClientePessoaFisica.EstadoCivil;

public class Carga {

    {
        Agencia agencia = null;
        try {
            agencia = new Agencia(2811, "Praia de Boa Viagem");
        } catch (AgenciaException e) {
            e.printStackTrace();
        }

        ClientePessoaFisica pedro = null;
        try {
            pedro = new ClientePessoaFisica("Pedro Adelino", "000.000.000-00", EstadoCivil.CASADO);
        } catch (ClienteException e) {
            e.printStackTrace();
        }

        try {
            new ContaCorrentePessoaFisica(agencia, 8214106, pedro);
        } catch (ContaException e) {
            e.printStackTrace();
        }

        ClientePessoaJuridica empresa = null;
        try {
            empresa = new ClientePessoaJuridica("MyBank", "000.000.001/0001-01");
        } catch (ClienteException e) {
            e.printStackTrace();
        }

        try {
            new ContaCorrentePessoaJuridica(agencia, 55, empresa);
        } catch (ContaException e) {
            e.printStackTrace();
        }
    }
}
