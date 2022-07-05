package br.com.letscode.modelos;

public class ContaCorrentePF extends ContaCorrente {
	
	ContaCorrentePF(int numero, PessoaFisica titular) {
		super(numero, titular, Taxa.PF);
	}

	public PessoaFisica getTitularPessoaFisica() {
		return (PessoaFisica) super.getTitular();
	}
}