package br.com.letscode.exercicioCompraCarro;

public class App {
    
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Creitin", 33);
        

        compraCarro(pessoa);

    }

    public static Par<Pessoa, Carro> compraCarro(Pessoa p) {
        String cor;
        if (p.getIdade() > 50) {
            cor = "branco";
        }
        cor = "preto";

        return new Par<Pessoa, Carro>(p, new Carro(cor));
    }

}
