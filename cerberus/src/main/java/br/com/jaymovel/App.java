package br.com.jaymovel;

import br.com.jaymovel.enums.TipoVeiculo;
import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.modelos.cadastro.Agencia;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.Veiculo;

public class App {
    public static void main(String[] args) throws JayMovelException {

        Pessoa ze = new PessoaFisica(
                "Zé da Silva",
                123,
                "Rua da Goiaba, 420",
                "(66) 6666-6666",
                "2000-01-01");

        Pessoa sandubas = new PessoaJuridica(
                "Sandubas",
                456,
                "endereco",
                "telefone",
                (PessoaFisica) ze);
        Veiculo carroPequeno = new Veiculo(TipoVeiculo.PEQUENO);
        Veiculo carroMedio = new Veiculo(TipoVeiculo.MEDIO);
        Veiculo suv = new Veiculo(TipoVeiculo.SUV);

        Agencia a = new Agencia();

        a.cadastraCliente(ze);
        a.novoAluguel(123, carroMedio, 4);
        System.out.println(a.calculaDivida(123));

        a.cadastraCliente(sandubas);
        a.novoAluguel(456, carroMedio, 1);
        a.novoAluguel(456, suv, 6);
        a.novoAluguel(456, carroPequeno, 2);
        System.out.println(a.calculaDivida(456));

        // ObjectInputStream ois = new ObjectInputStream(new
        // FileInputStream("dados.bin"));
        // Banco.selecionada = (Agencia) ois.readObject();
        // ois.close();
        // new TelaInicial();
        // ObjectOutputStream oos = new ObjectOutputStream(new
        // FileOutputStream("dados.bin"));
        // oos.writeObject(Banco.selecionada);
        // oos.close();
    }
}
