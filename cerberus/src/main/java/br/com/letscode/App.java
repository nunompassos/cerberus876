package br.com.letscode;

import br.com.letscode.modelos.Agencia;
import br.com.letscode.modelos.Banco;
import br.com.letscode.modelos.conta.ContaCorrente;
import br.com.letscode.modelos.pessoa.Pessoa;
import br.com.letscode.modelos.pessoa.PessoaFisica;
import br.com.letscode.telas.TelaInicial;

public class App {
    public static void main(String[] args) {
        Agencia ag1 = new Agencia(1);
        Pessoa ze = new PessoaFisica(
                "nome",
                123,
                "endereco",
                "telefone",
                "2000-01-01");

        ag1.cadastrarCliente(ze);
		ag1.abrirConta(ze, ContaCorrente.class);
        Banco.agencias.add(ag1);
        Banco.selecionada = ag1;
        new TelaInicial();
    }
}
