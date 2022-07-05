package br.com.letscode.modelos.Pessoa;

import br.com.letscode.excecoes.IdadeNegativaException;

public class PessoaFisica extends Pessoa {
	private int idade;
	private EstadoCivil estadoCivil;
	private Genero genero;
	private String profissao;

	public PessoaFisica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			int idade) {
		this.setNome(nome);
		this.setDocumento(documento);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setIdade(idade);
	}

	public PessoaFisica(
			String nome,
			int documento,
			String telefone,
			String endereco,
			int idade,
			char genero,
			char estadoCivil,
			String profissao) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setEstadoCivil(estadoCivil);
		this.setGenero(genero);
		this.setProfissao(profissao);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setDocumento(documento);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade < 0)
			throw new IdadeNegativaException();
		this.idade = idade;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(char estado) {
		this.estadoCivil = EstadoCivil.deChar(estado);
	}

	public Genero getGenero() {
		return genero;
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
				(this.getIdade() != 0 ? this.getIdade() + " anos, " : "") +
				(this.getProfissao() != null ? this.getProfissao() + ", " : "") +
				(this.getEstadoCivil() != null ? this.getEstadoCivil() + ", " : "") +
				(this.getGenero() != null ? this.getGenero() + ", " : "") +
				']';
	}
}
