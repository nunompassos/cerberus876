package br.com.mybank.projetofinal02;

public class Aplicacao {
    public static void main(String[] args) {
        
        Cliente clienteJ = new ClientePessoaJuridica("Bernardo");
        Veiculo veiculoP = new VeiculoPequeno();
        Veiculo veiculoM = new VeiculoMedio();
        Veiculo veiculoS = new VeiculoSuv();
        System.out.println("__________Teste Cliente Pessoa Juridica____________");
        //alugar carro pequeno
        Aluguel aluga = new Aluguel(clienteJ, veiculoP, 3);
        aluga.calculaAluguel();

        //alugar carro medio
        aluga = new Aluguel(clienteJ, veiculoM, 4);
        aluga.calculaAluguel();

        //alugar carro Suv
        aluga = new Aluguel(clienteJ, veiculoS, 4);
        aluga.calculaAluguel();

        Cliente clienteF = new ClientePessoaFisica("Ana");
        System.out.println("__________Teste Cliente Pessoa Fisica____________");
        System.out.println("");

        //alugar carro pequeno
        aluga = new Aluguel(clienteF, veiculoP, 6);
        aluga.calculaAluguel();

        //alugar carro medio
        aluga = new Aluguel(clienteF, veiculoM, 4);
        aluga.calculaAluguel();

        //alugar carro Suv
        aluga = new Aluguel(clienteF, veiculoS, 4);
        aluga.calculaAluguel();
    }  
}
