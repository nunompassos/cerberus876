package br.com.jaymovel.modelos.pessoa;

// import java.util.HashSet;
// import java.util.Set;
import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1000000L;

	private String nome;
	private String endereco;
	private String telefone;
	private int documento;

	Pessoa(String nome, String endereco, String telefone, int documento) {
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

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
	public boolean equals(Object obj) {
		if (!(obj instanceof Pessoa)) return false;
		return this.documento == ((Pessoa)obj).documento;
	}

	@Override
	public int hashCode() {
		return this.documento;
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
