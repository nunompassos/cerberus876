package br.com.pedro.modelos;

import br.com.pedro.modelos.ClientePessoaFisica.EstadoCivil;

public abstract class Carga {

    public static void iniciar() throws AgenciaException, ClienteException, ContaException {
        Agencia agencia = new Agencia(2811, "Praia de Boa Viagem");

        ClientePessoaFisica pedro = new ClientePessoaFisica("Pedro Adelino", "000.000.000-00", EstadoCivil.CASADO);

        new ContaCorrentePessoaFisica(agencia, 8214106, pedro);

        ClientePessoaJuridica empresa = new ClientePessoaJuridica("MyBank", "000.000.001/0001-01");

        new ContaCorrentePessoaJuridica(agencia, 55, empresa);
    }
}
