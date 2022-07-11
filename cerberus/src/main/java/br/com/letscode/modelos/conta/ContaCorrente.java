package br.com.letscode.modelos.conta;

import br.com.letscode.excecoes.LimiteInsuficienteException;
import br.com.letscode.excecoes.PagamentoExcessivoException;
import br.com.letscode.excecoes.SaldoInsuficienteException;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.util.ConverteSaldo;

public class ContaCorrente extends Conta {

	protected long divida;
	private long limite;

	public ContaCorrente(int numero, Pessoa titular) {
		super(numero, titular);
		this.limite = 0;
		this.divida = 0;
	}

	public void fazerEmprestimo(long emprestimo) throws LimiteInsuficienteException {
		validaValor(emprestimo);
		if (emprestimo + divida > this.limite)
			throw new LimiteInsuficienteException();

		super.saldo += emprestimo;
		this.divida += emprestimo;
	}

	@Override
	public void passarMes() {
		long juros = Math.round(this.divida * super.taxa.getJuros());
		this.divida += juros;
	}

	public void pagarDivida(long pagamento) throws PagamentoExcessivoException, SaldoInsuficienteException{
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
