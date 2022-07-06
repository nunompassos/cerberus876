package br.com.letscode.modelos.Agencia;

import java.util.ArrayList;

import br.com.letscode.modelos.Conta.*;
import br.com.letscode.modelos.Pessoa.*;

public class Agencia {
	private ArrayList<Conta> contas;
	private ArrayList<ContaCorrente> contasCorrente;
	private ArrayList<ContaPoupanca> contasPoupanca;
	private ArrayList<ContaInvestimento> contasInvestimento;

	private ArrayList<Pessoa> clientes;
	private ArrayList<PessoaFisica> clientesPf;
	private ArrayList<PessoaJuridica> clientesPj;
	
	public void addCliente(Pessoa pessoa) {
		if (clientes.contains(pessoa))
			return;
		clientes.add(pessoa);
	}

	public Pessoa getCliente(int documento) {
		for (Pessoa cliente : clientes) {
			if (cliente.getDocumento() == documento)
				return cliente;
		}
		return null;
	}

	public void addConta(Conta conta) {
		if (contas.contains(conta))
			return;
		contas.add(conta);
	}

	public Conta getConta(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero)
				return conta;
		}
		return null;
	}

	public void passarMes() {
		for (Conta conta : contas) {
			conta.passarMes();
		}
	}

}
