package br.com.letscode.modelos.pessoa;

import br.com.letscode.excecoes.PessoaDuplicadaException;

public class PessoaJuridica extends Pessoa {

	private PessoaFisica responsavel;

	public PessoaJuridica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			PessoaFisica responsavel) throws PessoaDuplicadaException {
		super(nome, endereco, telefone, documento);
		this.setResponsavel(responsavel);
	}

	public PessoaFisica getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(PessoaFisica responsavel) {
		if (responsavel == null)
			throw new IllegalArgumentException("Resonsável não pode ser nulo");
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "PJ: {" +
				super.toString() + ", " +
				"Responsavel: " + this.getResponsavel() +
				'}';
	}
}
