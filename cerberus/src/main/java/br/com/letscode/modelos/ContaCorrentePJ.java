package br.com.letscode.modelos;

public class ContaCorrentePJ extends ContaCorrente {
	
	public ContaCorrentePJ(int numero, PessoaJuridica titular) {
		super(numero, titular, Taxa.PJ);
	}

	public PessoaJuridica getTitularPessoaJuridica() {
		return (PessoaJuridica) super.getTitular();
	}
}
