package br.com.letscode.modelos;

public class ContaPessoaFisica extends Conta {
	
	ContaPessoaFisica(int numero, PessoaFisica titular) {
		super(numero, titular);
	}

	public PessoaFisica getTitularPessoaFisica() {
		return (PessoaFisica) super.getTitular();
	}
}