package br.com.letscode.model;


public class Aluno extends Pessoa implements EntidadeEscola {

    private int numeroMatricula;
    private int ano;
    private int numeroDisciplinasCompletas;

    public Aluno(String nome, Integer idade, Sexo sexo, String endereco, EstadoCivil estadoCivil, Double altura,
            Double peso, int numeroMatricula, int ano, int numeroDisciplinasCompletas) {
        super(nome, idade, sexo, endereco, estadoCivil, altura, peso);
        this.numeroMatricula = numeroMatricula;
        this.ano = ano;
        this.numeroDisciplinasCompletas = numeroDisciplinasCompletas;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumeroDisciplinasCompletas() {
        return numeroDisciplinasCompletas;
    }

    public void setNumeroDisciplinasCompletas(int numeroDisciplinasCompletas) {
        this.numeroDisciplinasCompletas = numeroDisciplinasCompletas;
    }

    @Override
    public String toString() {
        //TODO: Testar com StringBuilder e StringBuffer
        return String.format("Nome: %s\nIdade: %d\nMatrícula: %d\nAno: %d\nQuantidade de Disciplinas Completas: %d ",
         super.getNome(), super.getIdade(), this.getNumeroMatricula(), this.getAno(), this.getNumeroDisciplinasCompletas());
    }

    @Override
    public void matricular() {
        System.out.println("Acordar cedo todo dia?? naaaaao");
        
    }

    @Override
    public void iniciarAula() {
        System.out.println("quando é o recreio??? ");
        
    }

    @Override
    public void partiuRecreio() {
        System.out.println("partiu lanche!!!");
        
    }

}
