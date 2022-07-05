package br.com.pedro.classes;

public class ContaCorrentePessoaFisica extends Conta {

    private ClientePessoaFisica pessoa;

    public ContaCorrentePessoaFisica(Agencia agencia, int numeroConta, ClientePessoaFisica clientePessoaFisica) throws ContaException {
        super(agencia, numeroConta);
        this.pessoa = clientePessoaFisica;
        clientePessoaFisica.adicionarConta(this);
    }

    public ClientePessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(ClientePessoaFisica pessoa) {
        this.pessoa = pessoa;
    }
}
