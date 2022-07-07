package br.com.pedro.classes;

public class ContaCorrentePessoaFisica extends ContaCorrente {

    private ClientePessoaFisica pessoa;

    public ContaCorrentePessoaFisica(Agencia agencia, int numeroConta, ClientePessoaFisica clientePessoaFisica)
            throws ContaException {
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

    @Override
    public String toString() {
        return "Nome ...........: " + this.pessoa.getNome() + "\n"
                + "CPF ............: " + this.pessoa.getCpf() + "\n"
                + "Estado Civil ...: " + this.pessoa.getEstadoCivil() + "\n"
                + super.toString();
    }
}
