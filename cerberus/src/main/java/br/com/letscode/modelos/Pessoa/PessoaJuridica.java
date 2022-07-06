package br.com.letscode.modelos.Pessoa;

public class PessoaJuridica extends Pessoa {

	private PessoaFisica responsavel;

	public PessoaJuridica(
			String nome,
			int documento,
			String endereco,
			String telefone,
			PessoaFisica responsavel) {
		this.setNome(nome);
		this.setDocumento(documento);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
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
