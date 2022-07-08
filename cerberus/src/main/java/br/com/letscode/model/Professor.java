package br.com.letscode.model;

public class Professor extends Pessoa implements EntidadeEscola {

    

    public Professor(String nome, Integer idade, Sexo sexo, String endereco, EstadoCivil estadoCivil, Double altura,
            Double peso) {
        super(nome, idade, sexo, endereco, estadoCivil, altura, peso);
        //TODO Auto-generated constructor stub
    }

    public Professor(String nome, int i) {
        this(nome, 0, null, null, null, null, null);
    }

    @Override
    public void matricular() {
        System.out.println("Top, agora tenho um emprego!!");        
    }

    @Override
    public void iniciarAula() {
        System.out.println("Partiu aturar aquelas pestes");        
    }

    @Override
    public void partiuRecreio() {
        System.out.println("Cafezin na sala dos professores.");        
    }
    
}
