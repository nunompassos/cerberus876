package br.com.jaymovel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.telas.TelaInicial;

public class App {
    public static void main(String[] args) throws JayMovelException, IOException, ClassNotFoundException {

        Pessoa ze = new PessoaFisica(
                "Zé da Silva",
                123,
                "Rua da Goiaba, 420",
                "(66) 6666-6666",
                "2000-01-01");

        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"));
        // Banco.selecionada = (Agencia) ois.readObject();
        // ois.close();
        
        new TelaInicial();

        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"));
        // oos.writeObject(Banco.selecionada);
        // oos.close();
    }
}
