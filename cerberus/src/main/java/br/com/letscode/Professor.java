package br.com.letscode;

public class Professor extends Pessoa implements EntidadeEscola {

    public Professor(String nome, String endereco) {
        super(nome, endereco);
    }

    
    @Override
    public void comecarAula(String materia) {
        System.out.println("Hoje a aula é de " + materia);
        
    }

    @Override
    public void marcarPresenca() {
        System.out.println("Vou comecar a chamada, atencao!");
    }

    @Override
    public void chegarAEscola() {
        System.out.println("Vou estacionar o carro.");
        
    }

    @Override
    public void prepararMaterial() {
        System.out.println("Hora de fazer meu planejamento!");        
    }


    
}
