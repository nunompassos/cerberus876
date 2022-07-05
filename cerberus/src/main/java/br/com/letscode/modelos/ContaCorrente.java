package br.com.letscode.modelos;

public abstract class ContaCorrente extends Conta {

	protected long divida;
	private long limite;


	ContaCorrente(int numero, Pessoa titular, Taxa taxa) {
		super(numero, titular, taxa);
		this.limite = 0;
		this.divida = 0;
	}

	public void fazerEmprestimo(long emprestimo) {
		
	}
	
	public long getLimite() {
		return limite;
	}
	public void setLimite(long limite) {
		this.limite = limite;
	}

}
