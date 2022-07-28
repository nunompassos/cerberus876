package br.com.jaymovel.modelos.pessoa;

import java.time.LocalDate;
import java.time.Period;

public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1100000L;

	private final LocalDate nascimento;

	public PessoaFisica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			String nascimento) {
		super(nome, endereco, telefone, documento);
		this.nascimento = LocalDate.parse(nascimento);
	}

	public int getIdade() {
		return Period.between(nascimento, LocalDate.now()).getYears();
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	@Override
	public String toString() {
		return "PF:[" +
				super.toString() + ", " +
				this.getIdade() + " anos, " +
				']';
	}
}
