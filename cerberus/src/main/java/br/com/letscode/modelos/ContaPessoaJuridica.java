package br.com.letscode.modelos;

public class ContaPessoaJuridica extends Conta {
	
	public ContaPessoaJuridica(int numero, PessoaJuridica titular) {
		super(numero, titular);
	}

	public PessoaJuridica getTitularPessoaJuridica() {
		return (PessoaJuridica) super.getTitular();
	}
}
