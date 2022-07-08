package br.com.letscode.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import br.com.letscode.excecoes.AgenciaDuplicadaException;
import br.com.letscode.excecoes.ContaJaExisteException;
import br.com.letscode.modelos.contaa.*;
import br.com.letscode.modelos.pessoaa.*;
import br.com.letscode.util.DigitoVerificador;

public class Agencia {

	private final int numero;
	private final static ArrayList<Integer> numerosDeAgencia = new ArrayList<Integer>();

	private final ArrayList<Conta> contas;
	private final ArrayList<Integer> numerosDeConta;

	private final ArrayList<Pessoa> clientes;
	private final ArrayList<PessoaFisica> clientesPf;
	private final ArrayList<PessoaJuridica> clientesPj;

	// [0] = CC, [1] = CI, [2] = CP
	private final HashMap<Pessoa, Conta[]> mapPessoasContas;
	private final HashMap<Class<?>, Integer> posicao = new HashMap<Class<?>, Integer>();
	{
		posicao.put(ContaCorrente.class, 0);
		posicao.put(ContaInvestimento.class, 1);
		posicao.put(ContaPoupanca.class, 2);
	}

	public Agencia(int numero) {
		if (Agencia.numerosDeAgencia.contains(numero))
			throw new AgenciaDuplicadaException();
		this.numero = numero;
		Agencia.numerosDeAgencia.add(numero);

		mapPessoasContas = new HashMap<Pessoa, Conta[]>();

		contas = new ArrayList<Conta>();
		numerosDeConta = new ArrayList<Integer>();

		clientes = new ArrayList<Pessoa>();
		clientesPf = new ArrayList<PessoaFisica>();
		clientesPj = new ArrayList<PessoaJuridica>();
	}

	public void cadastrarCliente(Pessoa cliente) {
		if (cliente == null)
			throw new IllegalArgumentException("Cliente não pode ser nulo");
		if (PessoaFisica.class.isInstance(cliente))
			this.cadastrarCliente((PessoaFisica) cliente);
		else if (PessoaJuridica.class.isInstance(cliente))
			this.cadastrarCliente((PessoaJuridica) cliente);
	}

	private void cadastrarCliente(PessoaFisica pessoa) {
		if (clientes.contains(pessoa))
			return;
		clientes.add(pessoa);
		clientesPf.add(pessoa);
		mapPessoasContas.put(pessoa, new Conta[3]);
	}

	private void cadastrarCliente(PessoaJuridica empresa) {
		if (clientes.contains(empresa))
			return;
		clientes.add(empresa);
		clientesPj.add(empresa);
		mapPessoasContas.put(empresa, new Conta[3]);

		PessoaFisica dono = empresa.getResponsavel();
		if (clientesPf.contains(dono))
			return;
		clientesPf.add(dono);
	}

	public int abrirConta(Pessoa cliente, Class<?> tipoDeConta) {
		if (cliente == null)
			throw new IllegalArgumentException("Cliente não pode ser nulo");
		if (!posicao.containsKey(tipoDeConta))
			throw new IllegalArgumentException("tipoDeConta inválido");
		verificaSeTemConta(cliente, tipoDeConta);

		int numero = geraNumeroConta(tipoDeConta);
		this.cadastrarCliente(cliente);

		Conta novaConta;
		if (tipoDeConta == ContaCorrente.class)
			novaConta = new ContaCorrente(numero, cliente);
		else if (tipoDeConta == ContaInvestimento.class)
			novaConta = new ContaInvestimento(numero, cliente);
		else if (tipoDeConta == ContaPoupanca.class)
			novaConta = new ContaPoupanca(numero, (PessoaFisica) cliente);
		else
			throw new IllegalArgumentException("tipoDeConta inválido");

		mapPessoasContas.get(cliente)[posicao.get(tipoDeConta)] = novaConta;
		contas.add(novaConta);
		return numero;
	}

	private void verificaSeTemConta(Pessoa cliente, Class<?> tipoDeConta) {
		if (mapPessoasContas.get(cliente)[posicao.get(tipoDeConta)] != null) {
			Conta existente = mapPessoasContas.get(cliente)[0];
			throw new ContaJaExisteException("Cliente já tem conta-corrente com número " + existente.getNumero());
		}
	}

	private int geraNumeroConta(Class<?> tipoDeConta) {
		int numero;
		Random r = new Random();
		int min = 0;
		int max = (int) Math.pow(10, DigitoVerificador.numeroDeDigitos - 1) - 1;

		// Colocando o primeiro numero, que corresponde ao tipo de conta
		min = Integer.parseInt(posicao.get(tipoDeConta) + 1 + String.valueOf(max)) - max;
		max = Integer.parseInt(posicao.get(tipoDeConta) + 1 + String.valueOf(max));

		do {
			int numeroSemDigito = (int) (min + r.nextDouble() * (max - min));
			int digito = DigitoVerificador.calculaDigito(numeroSemDigito);
			numero = numeroSemDigito * 10 + digito;
		} while (numerosDeConta.contains(numero));
		numerosDeConta.add(numero);
		return numero;
	}

	public int getNumero() {
		return this.numero;
	}

	public Conta getConta(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero)
				return conta;
		}
		return null;
	}

	public Conta[] getContas(Pessoa cliente) {
		return mapPessoasContas.get(cliente);
	}

	public Pessoa getCliente(int documento) {
		for (Pessoa cliente : clientes) {
			if (cliente.getDocumento() == documento)
				return cliente;
		}
		return null;
	}

	public void passarMes() {
		for (Conta conta : contas) {
			conta.passarMes();
		}
	}

}
