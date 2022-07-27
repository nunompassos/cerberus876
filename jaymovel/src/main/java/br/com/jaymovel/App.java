package br.com.jaymovel;

import br.com.jaymovel.enums.TipoVeiculo;
import br.com.jaymovel.excecoes.JayMovelException;
import br.com.jaymovel.modelos.Agencia;
import br.com.jaymovel.modelos.pessoa.Pessoa;
import br.com.jaymovel.modelos.pessoa.PessoaFisica;
import br.com.jaymovel.modelos.pessoa.PessoaJuridica;
import br.com.jaymovel.modelos.veiculo.Veiculo;
import br.com.jaymovel.telas.TelaInicial;

public class App {
    public static void main(String[] args) throws JayMovelException {

        Agencia a = new Agencia();

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
        a.adicionaCliente(ze);
        a.adicionaCliente(sandubas);
        
        Veiculo carroPequeno = new Veiculo(TipoVeiculo.PEQUENO, 1);
        Veiculo carroMedio = new Veiculo(TipoVeiculo.MEDIO, 2);
        Veiculo suv = new Veiculo(TipoVeiculo.SUV, 3);
        a.adicionaVeiculo(carroPequeno);
        a.adicionaVeiculo(carroMedio);
        a.adicionaVeiculo(suv);
        // TODO criar um acervo de carros para pôr na Agência aqui na App

        // a.adicionaCliente(ze);
        // CadastroCliente cadastroZe = a.getCadastro(123);
        // cadastroZe.adicionaAluguel(carroMedio, 4);
        // System.out.println(cadastroZe.getDivida());

        // a.adicionaCliente(sandubas);
        // CadastroCliente cadastroSandubas = a.getCadastro(456);
        // cadastroSandubas.adicionaAluguel(carroMedio, 1);
        // cadastroSandubas.adicionaAluguel(suv, 6);
        // cadastroSandubas.adicionaAluguel(carroPequeno, 2);
        // System.out.println(cadastroSandubas.getDivida());

        // ObjectInputStream ois = new ObjectInputStream(new
        // FileInputStream("dados.bin"));
        // Banco.selecionada = (Agencia) ois.readObject();
        // ois.close();
        new TelaInicial(a);
        // ObjectOutputStream oos = new ObjectOutputStream(new
        // FileOutputStream("dados.bin"));
        // oos.writeObject(Banco.selecionada);
        // oos.close();
    }
}
