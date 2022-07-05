package br.com.letscode.modelos;

import br.com.letscode.excecoes.SaldoInsuficienteException;

public abstract class Conta {
	private final int numero;
	private Pessoa titular;
	private Taxa taxas;
	protected long saldo;

	Conta(int numero, Pessoa titular, Taxa taxa) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 0;
		this.taxas = taxa;
	}

	public void depositar(long deposito) {
		this.saldo += deposito;
	}

	public long sacar(long saque) {
		long taxa = Math.round(saque * taxas.getSaque());
		if (saque + taxa < this.saldo) {
			this.saldo -= saque + taxa;
			return saque;
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	public void transferir(long transferencia, Conta destino) {
		destino.depositar(this.sacar(transferencia));
	}

	public long getSaldoPuro() {
		return saldo;
	}

	public String getSaldoFormatado() {
		String digitos = String.valueOf(this.getSaldoPuro());
		String reais = digitos.substring(0, digitos.length() - 2);
		String centavos = digitos.substring(digitos.length() - 2, digitos.length());
		return "R$ " + reais + ',' + centavos;
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

	@Override
	public String toString() {
		return this.getNumero() + ", " +
				this.getSaldoFormatado() + ", " +
				this.getTitular() + ", ";

	}

}
