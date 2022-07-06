package br.com.letscode;

public class Pessoa {
    private String nome;
    private int idade;
    private Sexo sexo;
    private String endereco;
    private EstadoCivil estadoCivil;
    private int alturaEmCm;
    private int pesoEmKg;

    public Pessoa(String nome, int idade, Sexo sexo, String endereco, EstadoCivil estadoCivil, int altura,
            int peso) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.alturaEmCm = altura;
        this.pesoEmKg = peso;
    }

    public Pessoa(String nome, String endereco) {
        this(nome, 0, null, endereco, null, 0, 0);
    }

    public enum Sexo {
        MASCULINO, FEMININO, NEUTRO
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getAltura() {
        return alturaEmCm;
    }

    public void setAltura(int altura) {
        this.alturaEmCm = altura;
    }

    public int getPeso() {
        return pesoEmKg;
    }

    public void setPeso(int peso) {
        this.pesoEmKg = peso;
    }

}
