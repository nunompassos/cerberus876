package br.com.letscode.modelos.Conta;

import br.com.letscode.enums.Taxa;
import br.com.letscode.excecoes.SaldoInsuficienteException;
import br.com.letscode.modelos.Pessoa.Pessoa;
import br.com.letscode.util.ConverteSaldo;

public abstract class Conta {
	private final int numero;
	private Pessoa titular;
	protected final Taxa taxa;
	protected long saldo;

	public abstract void passarMes();

	Conta(int numero, Pessoa titular, Taxa taxa) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 0;
		if (taxa == null) throw new IllegalArgumentException("Taxa inválida");
		this.taxa = taxa;
	}

	public void depositar(long deposito) {
		validaValor(deposito);
		this.saldo += deposito;
	}

	protected long tirar(long retirada, double taxa) {
		validaValor(retirada);
		long tarifa = Math.round(retirada * taxa);
		if (retirada + tarifa < this.saldo) {
			this.saldo -= retirada + tarifa;
			return retirada;
		}
		throw new SaldoInsuficienteException();
	}

	public long sacar(long saque) {
		validaValor(saque);
		return tirar(saque, this.taxa.getSaque());
	}

	public void transferir(long transferencia, Conta destino) {
		destino.depositar(
				this.tirar(
						transferencia,
						this.getTitular() == destino.getTitular() ? 0 : this.taxa.getTransferencia()
		));
	}

	public long getSaldoPuro() {
		return saldo;
	}

	public String getSaldoFormatado() {
		return ConverteSaldo.comCifrao(this.saldo);
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	protected void validaValor(long valor) {
		if (valor < 0)
			throw new IllegalArgumentException("Valor deve ser positivo");
	}

	@Override
	public String toString() {
		return this.getNumero() + ", " +
				this.getTitular().getNome() + ", " +
				"Saldo: " + ConverteSaldo.semCifrao(this.saldo) + ", ";
	}

}
