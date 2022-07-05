package br.com.letscode.modelos.Conta;

import br.com.letscode.excecoes.LimiteInsuficienteException;
import br.com.letscode.excecoes.PagamentoExcessivoException;
import br.com.letscode.modelos.Pessoa.Pessoa;
import br.com.letscode.util.ConverteSaldo;

public abstract class ContaCorrente extends Conta {

	protected long divida;
	private long limite;

	ContaCorrente(int numero, Pessoa titular, Taxa taxa) {
		super(numero, titular, taxa);
		this.limite = 0;
		this.divida = 0;
	}

	public void fazerEmprestimo(long emprestimo) {
		validaValor(emprestimo);
		if (emprestimo + divida > this.limite)
			throw new LimiteInsuficienteException();

		super.saldo += emprestimo;
		this.divida += emprestimo;
	}

	@Override
	public void passarMes() {
		long juros = Math.round(this.divida * super.getTaxa().getJuros());
		this.divida += juros;
	}

	public void pagarDivida(long pagamento) {
		super.validaValor(pagamento);
		if (pagamento > this.divida)
			throw new PagamentoExcessivoException();

		this.divida -= super.tirar(pagamento, 0);
	}

	public long getLimite() {
		return limite;
	}

	public String getLimiteFormatado() {
		return ConverteSaldo.comCifrao(this.limite);
	}

	public long getDivida() {
		return this.divida;
	}

	public String getDividaFormatada() {
		return ConverteSaldo.comCifrao(this.divida);
	}

	public void setLimite(long limite) {
		super.validaValor(limite);
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "CC: {" + super.toString() + 
				"Limite: " + ConverteSaldo.semCifrao(this.limite) + ", " +
				"Divida: " + ConverteSaldo.semCifrao(this.divida) +
				'}';
	}

}
