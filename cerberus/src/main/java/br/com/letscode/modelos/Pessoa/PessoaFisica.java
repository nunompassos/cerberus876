package br.com.letscode.modelos.Pessoa;

import java.time.LocalDate;
import java.time.Period;

import br.com.letscode.excecoes.IdadeNegativaException;

public class PessoaFisica extends Pessoa {

	private final LocalDate nascimento;
	private EstadoCivil estadoCivil;
	private Genero genero;
	private String profissao;

	public PessoaFisica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			String nascimento) {
		this.setNome(nome);
		this.setDocumento(documento);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.nascimento = LocalDate.parse(nascimento);
	}

	public PessoaFisica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			String nascimento,
			char genero,
			char estadoCivil,
			String profissao) {
		this(nome, documento, endereco, telefone, nascimento);
		this.setGenero(genero);
		if (this.getGenero() == null)
			throw new IllegalArgumentException("char " + genero + " não é um gênero");
		this.setEstadoCivil(estadoCivil);
		if (this.getEstadoCivil() == null)
			throw new IllegalArgumentException("char " + estadoCivil + " não é um estado civil");
		this.setProfissao(profissao);
	}

	public int getIdade() {
		return Period.between(nascimento, LocalDate.now()).getYears();
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(char estado) {
		this.estadoCivil = EstadoCivil.deChar(estado);
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(char genero) {
		this.genero = Genero.deChar(genero);
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "PF:[" +
				super.toString() + ", " +
				this.getIdade() + " anos, " +
				(this.getProfissao() != null ? this.getProfissao() + ", " : "") +
				(this.getEstadoCivil() != null ? this.getEstadoCivil().toString(
						this.getGenero()) + ", " : "")
				+
				(this.getGenero() != null ? this.getGenero() + ", " : "") +
				']';
	}
}
