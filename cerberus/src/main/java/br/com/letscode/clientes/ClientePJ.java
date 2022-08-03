package br.com.letscode.clientes;

public class ClientePJ extends Cliente implements OperacoesTaxadas {

    public ClientePJ(String _nome, String _cnpj) {
        super(_nome, _cnpj);
    }
}
