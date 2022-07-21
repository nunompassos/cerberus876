package br.com.letscode.modelos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.com.letscode.excecoes.AgenciaDuplicadaException;
import br.com.letscode.excecoes.ContaJaExisteException;
import br.com.letscode.modelos.conta.*;
import br.com.letscode.modelos.pessoa.*;
import br.com.letscode.util.DigitoVerificador;

public class Agencia implements Serializable {

	private static final long serialVersionUID = 3000000L;
	private static final Set<Integer> numerosDeAgencia = new HashSet<>();
	private static final Map<Class<?>, Integer> posicao = new HashMap<>();
	{
		posicao.put(ContaCorrente.class, 0);
		posicao.put(ContaInvestimento.class, 1);
		posicao.put(ContaPoupanca.class, 2);
	}

	private final int numero;
	private final Set<Pessoa> clientes = new HashSet<>();
	private final Set<Integer> numerosDeConta = new HashSet<>();
	private final Map<Integer, Conta> contas = new HashMap<>();
	private final Map<Pessoa, Conta[]> mapPessoasContas = new HashMap<>();// [0] = CC, [1] = CI, [2] = CP
	

	public Agencia(int numero) throws AgenciaDuplicadaException{
		if (Agencia.numerosDeAgencia.contains(numero))
			throw new AgenciaDuplicadaException();
		this.numero = numero;
		Agencia.numerosDeAgencia.add(numero);
	}

	public void cadastrarCliente(Pessoa cliente) {
		if (cliente instanceof PessoaFisica)
			this.cadastrarCliente((PessoaFisica) cliente);
		else if (cliente instanceof PessoaJuridica)
			this.cadastrarCliente((PessoaJuridica) cliente);
		else 
			throw new ClassCastException("Tipo de cliente inválido");
	}

	private void cadastrarCliente(PessoaFisica pessoa) {
		if (clientes.contains(pessoa))
			return;
		clientes.add(pessoa);
		mapPessoasContas.put(pessoa, new Conta[3]);
	}

	private boolean cadastrarCliente(PessoaJuridica empresa) {
		if (clientes.contains(empresa))
			return false;
		clientes.add(empresa);
		mapPessoasContas.put(empresa, new Conta[3]);

		PessoaFisica dono = empresa.getResponsavel();
		if (!clientes.contains(dono))
			clientes.add(dono);
		return true;
	}

	public int abrirConta(Pessoa cliente, Class<?> tipoDeConta) throws ContaJaExisteException {
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
		contas.put(novaConta.getNumero(), novaConta);
		return numero;
	}

	private void verificaSeTemConta(Pessoa cliente, Class<?> tipoDeConta) throws ContaJaExisteException {
		if (mapPessoasContas.get(cliente)[posicao.get(tipoDeConta)] != null) {
			Conta existente = mapPessoasContas.get(cliente)[0];
			throw new ContaJaExisteException(String.format("Cliente já tem %s com número %d", tipoDeConta.getName(), existente.getNumero()));
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
				return contas.get(numero);
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
		contas.forEach((numero, conta) -> {conta.passarMes();});
	}
}
