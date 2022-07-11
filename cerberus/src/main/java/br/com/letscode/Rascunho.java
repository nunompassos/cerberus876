package br.com.letscode;

import java.time.LocalDate;

import br.com.letscode.excecoes.BancoJayException;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.modelos.pessoa.PessoaFisica;
import br.com.letscode.modelos.pessoa.PessoaJuridica;

public class Rascunho {
	public static void main(String[] args) throws BancoJayException {
		PessoaFisica ze = new PessoaFisica("nome", 2, "endereco", "telefone", "2000-01-01");
		Pessoa emp = new PessoaJuridica("nome", 1, "endereco", "telefone", ze);
		ze = (PessoaFisica) emp;
	}
}
