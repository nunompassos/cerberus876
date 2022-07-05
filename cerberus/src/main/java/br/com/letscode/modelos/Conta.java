package br.com.letscode.modelos;

import br.com.letscode.excecoes.SaldoInsuficienteException;

public abstract class Conta {
	private final int numero;
	private Pessoa titular;
	private long limite;
	protected long saldo;

	Conta(int numero, Pessoa titular) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 0;
		this.limite = 0;
	}

	public void depositar(long deposito) {
		this.saldo += deposito;
	}

	public long sacar(long saque) {
		if (saque < this.saldo) {
			this.saldo -= saque;
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

	public long getLimite() {
		return limite;
	}

	public void setLimite(long limite) {
		this.limite = limite;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Conta: {" +
		this.getNumero() + " " +
		this.getSaldoFormatado() + " " +
		this.getTitular() + " " +
		'}';
		
	}

}
