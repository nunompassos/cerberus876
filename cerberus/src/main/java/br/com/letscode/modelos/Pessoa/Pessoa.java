package br.com.letscode.modelos.Pessoa;

public abstract class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;
	private int documento;

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return
				this.getNome() + ", " +
				this.getDocumento() + ", " +
				this.getEndereco() + ", " +
				this.getTelefone();
	}
}
