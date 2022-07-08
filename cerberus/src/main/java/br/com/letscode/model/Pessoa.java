package br.com.letscode.model;

/**
 * Criar uma classe Pessoa, com atributos:nome, idade, sexo, morada, estado civil, altura, peso
 *
 */
public class Pessoa {
    
    private String nome;
    private Integer idade;
    private Sexo sexo;
    private String endereco;
    private EstadoCivil estadoCivil;
    private Double altura;
    private Double peso;

    public Pessoa(String nome, Integer idade, Sexo sexo, String endereco, EstadoCivil estadoCivil, Double altura, Double peso) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.altura = altura;
        this.peso = peso;
    }

    public Pessoa(String nome, String endereco) {
        this(nome, 0, null, endereco, null, null, null);
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}