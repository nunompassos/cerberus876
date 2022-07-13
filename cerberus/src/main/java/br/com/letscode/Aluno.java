package br.com.letscode;

public class Aluno extends Pessoa implements EntidadeEscola {

    private int numeroMatricula;
    private int ano;
    private int numeroDisciplinasCompletas;

    public Aluno(String nome) {
        super(nome, null);
    }   

    public Aluno(String nome, int numeroMatricula, int ano, int numeroDisciplinasCompletas) {
        super(nome, null);
        this.numeroMatricula = numeroMatricula;
        this.ano = ano;
        this.numeroDisciplinasCompletas = numeroDisciplinasCompletas;
    }    

    @Override
    public String toString() {
        String string = String.format("Eu sou %s, aluno do ano %d, minha matrícula é %d e tenho %d disciplinas completas.", 
            this.getNome(), 
            this.ano, 
            this.numeroMatricula,
            this.numeroDisciplinasCompletas);

        return string;
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
    public void comecarAula(String materia) {
        System.out.println("Bom dia, professor! Eu adoro " + materia);
    }
    
    @Override
    public void marcarPresenca() {
        System.out.println(this.getNome() + " presente!");
        
    }

    @Override
    public void chegarAEscola() {
        System.out.println("Vou pra sala.");        
    }

    @Override
    public void prepararMaterial() {
        System.out.println("É... Melhor eu fazer o dever de casa.");
    }

}
