package br.com.letscode.nivelamento;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalculaAniversario {
    
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Creito", LocalDate.of(1989, Month.FEBRUARY, 1));
        Pessoa p2 = new Pessoa("Creitinha", LocalDate.of(1994, Month.OCTOBER, 23));
        Pessoa p3 = new Pessoa("Creitasso", LocalDate.of(1884, Month.DECEMBER, 15));

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        pessoas.forEach((pessoa) -> {
            pessoa.calcularIdade();
            System.out.printf("%s tem %d anos.\n", pessoa.getNome(), pessoa.getIdade());
        });

    }
}

class Pessoa {
    private LocalDate nascimento;
    private String nome;
    private int idade;

    public Pessoa (final String nome, final LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void calcularIdade() {
        LocalDate hojeFormatado = this.getLocalDateFormatado(LocalDate.now());
        LocalDate nascimentoFormatado = this.getLocalDateFormatado(this.nascimento);

        Period intervalo = Period.between(nascimentoFormatado, hojeFormatado);
        this.setIdade(intervalo.getYears() + 99);        
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    private LocalDate getLocalDateFormatado(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String text = data.format(formatter);
        LocalDate dataFormatada = LocalDate.parse(text, formatter);
        return dataFormatada;
    }
    
}
